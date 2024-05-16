package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.acme.dto.filter.ProdutoFilterDTO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Produto extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer qtdeEstoque;


    public static List<Produto> findByProdutoFilterDTO (ProdutoFilterDTO filtro){

        //Inicializando o texto da query
        StringBuilder queryBuilder = new StringBuilder("1=1");

        //Inicializando os parametros
        Map<String, Object> params = new HashMap<>();

        if (filtro.getNome() != null) {
            queryBuilder.append(" AND nome = :nome");
            params.put("nome", filtro.getNome());
        }
        if (filtro.getPrecoDe() != null) {
            queryBuilder.append(" AND preco >= :precoDe");
            params.put("precoDe", filtro.getPrecoDe());
        }
        if (filtro.getPrecoAte() != null) {
            queryBuilder.append(" AND preco <= :precoAte");
            params.put("precoAte", filtro.getPrecoAte());
        }

        //query = 1=1 AND nome = :nome AND preco >= :precoDe AND preco <= :precoAte
        PanacheQuery<Produto> query = Produto.find(queryBuilder.toString(), params);

        // Configurando a paginação
        if (filtro.getPage() != null && filtro.getSize() != null) {
            query = query.page(filtro.getPage(), filtro.getSize());
        }
        return query.list();
    }
}


