package br.com.douglassouza.pedidos.processador.infrastructure.adapter.out;

import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;
import br.com.douglassouza.pedidos.processador.infrastructure.repository.ItemPedidoRepository;
import br.com.douglassouza.pedidos.processador.port.out.ItemPedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ItemPedidoRepositoryAdapter implements ItemPedidoRepositoryPort {

    private final ItemPedidoRepository itemPedidoRepository;


    @Override
    public List<ItemPedido> saveAll(List<ItemPedido> listaItemPedido) {
        return itemPedidoRepository.saveAll(listaItemPedido);
    }

    @Override
    public void updateItem(List<ItemPedido> listaItemPedidos) {

    }

    @Override
    public ItemPedido save(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }
}

