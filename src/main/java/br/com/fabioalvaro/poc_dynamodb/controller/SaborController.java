package br.com.fabioalvaro.poc_dynamodb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioalvaro.poc_dynamodb.application.SaborService;
import br.com.fabioalvaro.poc_dynamodb.model.Sabor;


/**
 * Controller para gerenciar as requisições HTTP relacionadas ao domínio Sabor.
 */
@RestController
@RequestMapping("/sabores")
public class SaborController {

    @Autowired
    private SaborService saborService;

    /**
     * Cria um novo sabor.
     * Recebe um Sabor no corpo da requisição e o envia para a camada de serviço.
     *
     * @param sabor O objeto Sabor a ser criado.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criaSabor(@RequestBody Sabor sabor) {
        saborService.criarSabor(sabor);
    }
}