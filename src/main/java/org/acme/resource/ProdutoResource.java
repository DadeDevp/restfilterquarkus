package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.filter.ProdutoFilterDTO;
import org.acme.dto.rest.ProdutoRequestDTO;
import org.acme.dto.rest.ProdutoResponseDTO;
import org.acme.entity.Produto;
import org.acme.service.ProdutoService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
public class ProdutoResource {

    @Inject
    ProdutoService produtoService;

    @POST
    @Transactional
    public Response inserir(ProdutoRequestDTO produtoRequestDTO) {

        ProdutoResponseDTO produtoResponseDTO = produtoService.inserir(produtoRequestDTO);

        return Response.ok(produtoResponseDTO).build();

//        URI uri = UriBuilder.fromResource(ProdutoResource.class) // Ajuste CustomerResource para sua classe de recurso correto
//                .path("{id}").resolveTemplate("id", produtoResponseDTO.getId()).build();
//
//        return Response.created(uri).build();
    }

    @GET
    public Response listarPorFiltro(@BeanParam ProdutoFilterDTO produtoFilterDTO) {
        //http://localhost:8080/produtos?nome=Produto%201&precoAte=250&precoDe=10

        List<Produto> produtos = produtoService.listarTodos(produtoFilterDTO);
        return Response.ok(produtos).build();
    }

}
