package br.com.fabioalvaro.poc_dynamodb.client;

import br.com.fabioalvaro.poc_dynamodb.model.Sabor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Cliente Feign para se comunicar com a API de Sabores.
 * <p>
 * A URL do serviço é configurável através da propriedade 'sabores.api.url'
 * no arquivo application.properties.
 * </p>
 */
@FeignClient(name = "sabor-client", url = "${sabores.api.url}")
public interface SaborClient {

    /**
     * Envia uma requisição POST para criar um novo sabor no serviço externo.
     *
     * @param sabor O objeto Sabor a ser criado.
     */
    @PostMapping("/sabores")
    void criaSabor(@RequestBody Sabor sabor);
}