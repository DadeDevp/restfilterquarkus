package org.acme.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.acme.entity.Produto;

import java.math.BigDecimal;

@Singleton
public class CargaBancoStartup {

    @Transactional
    public void loadProducts(@Observes StartupEvent evt) {
        // Verificar se já existem produtos para evitar duplicações
        if (Produto.count() == 0) {
            for (int i = 1; i <= 10; i++) {
                Produto produto = new Produto();
                produto.setNome("Produto " + i);
                produto.setPreco(BigDecimal.valueOf(100 + i * 10));
                produto.setQtdeEstoque(10 * i);
                produto.persist();
            }
        }

        for (int i = 1 ; i <=5 ; i++) {
            Produto produto1 = new Produto();
            produto1.setNome("Produto 1");
            produto1.setPreco(BigDecimal.valueOf(150 * i ));
            produto1.setQtdeEstoque(5*i);
            produto1.persist();
        }

        for (int i = 1 ; i <=3 ; i++) {
            Produto produto1 = new Produto();
            produto1.setNome("Produto 2");
            produto1.setPreco(BigDecimal.valueOf(150 * i ));
            produto1.setQtdeEstoque(5*i);
            produto1.persist();
        }

    }
}
