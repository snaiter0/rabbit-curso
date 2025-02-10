package br.com.douglassouza.pedidos.processador.port.out;

import java.util.List;

import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;

public interface ItemPedidoRepositoryPort {
    
    List<ItemPedido> saveAll(List<ItemPedido> listaItemPedido);

    void updateItem(List<ItemPedido> listaItemPedidos);

    ItemPedido save(ItemPedido itemPedido);
}
