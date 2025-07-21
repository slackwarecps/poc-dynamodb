package br.com.fabioalvaro.poc_dynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabioalvaro.poc_dynamodb.model.Cor;

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


    @PutMapping("/{codigo}")
    public ResponseEntity<Cor> atualizaCor(@PathVariable String codigo, @RequestBody Cor cor) {
        Cor corAtualizada = corService.atualizar(codigo, cor);
        return corAtualizada != null ? ResponseEntity.ok(corAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public void deletaCor(@PathVariable String codigo) {
        corService.deletar(codigo);
    }
}