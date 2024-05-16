package org.acme.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;
import org.acme.dto.rest.ProdutoRequestDTO;
import org.acme.dto.rest.ProdutoResponseDTO;
import org.acme.entity.Produto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-16T01:29:27-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@ApplicationScoped
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto produtoRequestDtoTOproduto(ProdutoRequestDTO produtoRequestDTO) {
        if ( produtoRequestDTO == null ) {
            return null;
        }

        Produto produto = new Produto();

        return produto;
    }

    @Override
    public ProdutoResponseDTO produtoTOprodutoResponseDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();

        return produtoResponseDTO;
    }
}
