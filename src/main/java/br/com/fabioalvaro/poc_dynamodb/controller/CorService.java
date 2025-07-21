package br.com.fabioalvaro.poc_dynamodb.controller;

import br.com.fabioalvaro.poc_dynamodb.model.Cor;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorService {

    @Autowired
    private DynamoDBMapper mapper;

    public List<Cor> buscarTodas() {
        return mapper.scan(Cor.class, new DynamoDBScanExpression());
    }

    public void salvar(Cor cor) {
        mapper.save(cor);
    }

    public Cor buscarPorCodigo(String codigo) {
        return mapper.load(Cor.class, codigo);
    }

    public void deletar(String codigo) {
        Cor cor = new Cor();
        cor.setCodigo(codigo);
        mapper.delete(cor);
    }

  
    public Cor atualizar(String codigo, Cor corDadosAtualizados) {
        Cor corExistente = mapper.load(Cor.class, codigo);
        if (corExistente == null) {
            return null; // Indica que a cor não foi encontrada
        }

        // Garante que o código do objeto a ser salvo é o mesmo da URL
        corDadosAtualizados.setCodigo(codigo);
        mapper.save(corDadosAtualizados); // O save sobrescreve o item existente
        return corDadosAtualizados;
    }
}