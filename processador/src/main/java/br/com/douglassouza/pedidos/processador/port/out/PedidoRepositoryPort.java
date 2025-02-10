package br.com.douglassouza.pedidos.processador.port.out;


import br.com.douglassouza.pedidos.processador.domain.model.Pedido;

public interface PedidoRepositoryPort {

    void save(Pedido pedido);
}
