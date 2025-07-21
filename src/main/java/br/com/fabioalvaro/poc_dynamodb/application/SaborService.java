package br.com.fabioalvaro.poc_dynamodb.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabioalvaro.poc_dynamodb.client.SaborClient;
import br.com.fabioalvaro.poc_dynamodb.model.Sabor;

/**
 * Camada de serviço para operações de negócio relacionadas a Sabor.
 * Delega a persistência para um cliente de API externa.
 */
@Service
public class SaborService {

    @Autowired
    private SaborClient saborClient;

    /**
     * Cria um novo sabor enviando-o para o serviço externo.
     *
     * @param sabor O Sabor a ser criado.
     */
    public void criarSabor(Sabor sabor) {
        // A lógica de negócio viria aqui antes de chamar o cliente.
        saborClient.criaSabor(sabor);
    }
}