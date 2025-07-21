

package br.com.fabioalvaro.poc_dynamodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa o domínio Sabor.
 * Contém o código e a descrição de um sabor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sabor {

    /**
     * O código único do sabor.
     */
    private Integer codigo;

    /**
     * A descrição textual do sabor.
     */
    private String descricao;
}