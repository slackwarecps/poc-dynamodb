package br.com.fabioalvaro.poc_dynamodb.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

@Configuration
public class DynamoDbConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDB(
        @Value("${aws.dynamodb.endpoint}") String endpoint,
        @Value("${aws.dynamodb.region}") String region,
        @Value("${aws.dynamodb.access-key}") String accessKey,
        @Value("${aws.dynamodb.secret-key}") String secretKey,
        @Value("${spring.profiles.active:}") String activeProfile
    ) {
        if ("local".equals(activeProfile)) {
            return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(endpoint, region)
                )
                .withCredentials(
                    new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey, secretKey)
                    )
                )
                .build();
        } else {
            return AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        }
    }


    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
        return new DynamoDBMapper(amazonDynamoDB);
    }


}