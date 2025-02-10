package br.com.douglassouza.pedidos.processador.infrastructure.repository;

import br.com.douglassouza.pedidos.processador.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
