package br.com.douglassouza.pedidos.processador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;
import br.com.douglassouza.pedidos.processador.domain.model.Pedido;
import br.com.douglassouza.pedidos.processador.port.in.ItemPedidoServicePort;
import br.com.douglassouza.pedidos.processador.port.out.ItemPedidoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemPedidoService implements ItemPedidoServicePort {

    private final ItemPedidoRepositoryPort itemPedidoRepositoryPort;

    @Override
    public List<ItemPedido> save(List<ItemPedido> itens) {
       return itemPedidoRepositoryPort.saveAll(itens);
    }

    private void save (ItemPedido itemPedido) {
        itemPedidoRepositoryPort.save(itemPedido);
    }

    @Override
    public void updateItemPedido(List<ItemPedido> listaItemPedidos, Pedido pedido) {

        listaItemPedidos.forEach(itemPedido -> {
            itemPedido.setPedido(pedido); // informando ao item o seu pedido.
            itemPedido.setProduto(itemPedido.getProduto());
            this.save(itemPedido);
        });
    }
}
