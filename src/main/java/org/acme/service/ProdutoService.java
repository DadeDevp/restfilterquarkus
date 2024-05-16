package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.filter.ProdutoFilterDTO;
import org.acme.dto.rest.ProdutoRequestDTO;
import org.acme.dto.rest.ProdutoResponseDTO;
import org.acme.entity.Produto;

import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Transactional
    public ProdutoResponseDTO inserir(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = ProdutoRequestDTO.toProduto(produtoRequestDTO);
        produto.persist();
        return ProdutoResponseDTO.toProdutoResponseDTO(produto);
    }

    public List<Produto> listarTodos(ProdutoFilterDTO produtoFilterDTO) {
        return Produto.findByProdutoFilterDTO(produtoFilterDTO);
    }
}
