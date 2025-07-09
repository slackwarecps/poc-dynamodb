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
}