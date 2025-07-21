package br.com.fabioalvaro.poc_dynamodb.client;

import br.com.fabioalvaro.poc_dynamodb.model.Cor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Cliente Feign para se comunicar com a API de Cores.
 * <p>
 * A URL do serviço é configurável através da propriedade 'cores.api.url'
 * no arquivo application.properties.
 * </p>
 */
@FeignClient(name = "cores-client", url = "${cores.api.url:http://localhost:8089}")
public interface CoresClient {

    /**
     * Envia uma requisição POST para criar uma nova cor.
     */
    @PostMapping("/portobank/v1/conta-digital/persistence/cores")
    void criaCor(@RequestBody Cor cor);
}