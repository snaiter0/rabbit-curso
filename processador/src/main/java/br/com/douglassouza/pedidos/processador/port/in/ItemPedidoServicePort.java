package br.com.douglassouza.pedidos.processador.port.in;

import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;
import br.com.douglassouza.pedidos.processador.domain.model.Pedido;

import java.util.List;

public interface ItemPedidoServicePort {

    List<ItemPedido> save(List<ItemPedido> itens);

    public void updateItemPedido(List<ItemPedido> listaItemPedidos, Pedido pedido);
}
