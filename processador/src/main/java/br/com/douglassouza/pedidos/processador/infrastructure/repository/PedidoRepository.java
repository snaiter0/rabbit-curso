package br.com.douglassouza.pedidos.processador.infrastructure.repository;

import br.com.douglassouza.pedidos.processador.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
