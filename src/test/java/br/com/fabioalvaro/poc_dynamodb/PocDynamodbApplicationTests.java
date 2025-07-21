package br.com.fabioalvaro.poc_dynamodb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PocDynamodbApplicationTests {

 

    @Test
    void meuTesteFalsoQueSemprePassa() {
        assertTrue(true, "Este teste foi projetado para sempre passar.");
    }

}
