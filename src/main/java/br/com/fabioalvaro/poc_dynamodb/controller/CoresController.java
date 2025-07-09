package br.com.fabioalvaro.poc_dynamodb.controller;

import br.com.fabioalvaro.poc_dynamodb.model.Cor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cores")
public class CoresController {

    @Autowired
    private CorService corService;

    @GetMapping
    public List<Cor> buscaTodasAsCores() {
        return corService.buscarTodas();
    }

    @PostMapping
    public void criaCor(@RequestBody Cor cor) {
        corService.salvar(cor);
    }

    @GetMapping("/{codigo}")
    public Cor buscaCor(@PathVariable String codigo) {
        return corService.buscarPorCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    public void deletaCor(@PathVariable String codigo) {
        corService.deletar(codigo);
    }
}