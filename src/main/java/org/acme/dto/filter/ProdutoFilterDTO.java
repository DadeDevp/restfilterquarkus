package org.acme.dto.filter;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoFilterDTO {
    @QueryParam("nome")
    @Parameter(description = "Nome do produto")
    private String nome;

    @QueryParam("precoDe")
    @Parameter(description = "Preço mínimo")
    private BigDecimal precoDe;

    @QueryParam("precoAte")
    @Parameter(description = "Preço máximo")
    private BigDecimal precoAte;

    @QueryParam("page")
    @Parameter(description = "Número da página")
    private Integer page;

    @QueryParam("size")
    @Parameter(description = "Quantidade de produtos por página")
    private Integer size;
}
