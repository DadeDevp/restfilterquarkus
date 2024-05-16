package org.acme.dto.rest;

import lombok.Getter;
import lombok.Setter;
import org.acme.entity.Produto;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoRequestDTO {
    private String nome;
    private BigDecimal preco;
    private Integer qtdeEstoque;

    public static Produto toProduto(ProdutoRequestDTO produtoRequestDTO){
        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.nome);
        produto.setPreco(produtoRequestDTO.preco);
        produto.setQtdeEstoque(produtoRequestDTO.qtdeEstoque);

        return produto;
    }
}
