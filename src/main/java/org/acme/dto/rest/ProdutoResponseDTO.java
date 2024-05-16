package org.acme.dto.rest;

import lombok.Getter;
import lombok.Setter;
import org.acme.entity.Produto;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer qtdeEstoque;

    public static ProdutoResponseDTO toProdutoResponseDTO(Produto produto){
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
        produtoResponseDTO.setId(produto.getId());
        produtoResponseDTO.setNome(produto.getNome());
        produtoResponseDTO.setPreco(produto.getPreco());
        produtoResponseDTO.setQtdeEstoque(produto.getQtdeEstoque());

        return produtoResponseDTO;
    }
}
