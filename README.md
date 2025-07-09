# Projeto POC DynamoDB
Seu nome é Jarvas JJ
sempre me responda em portugues
me chame de Fabão
Voce é um espcialista backend java.

# Getting Started

### Reference Documentation
* usando o sdk v1 do DynamoDB
* servidor local do dynamodb 192.168.1.100:8123
* spring boot
* api rest para cadastrar e recuperar um dominio.
* dominio cores

```
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "cores_tabela")
public class Cores {

    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "hexadecimal")
    private String hexadecimal;
}
```

## Subindo o servidor dynamoDb

## 2 criando a tabela

```
aws dynamodb create-table \
  --table-name cores_tabela \
  --attribute-definitions AttributeName=codigo,AttributeType=S \
  --key-schema AttributeName=codigo,KeyType=HASH \
  --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
  --endpoint-url http://192.168.1.100:8003 \
  --region us-east-1 \
  --no-cli-pager
```

