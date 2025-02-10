package br.com.douglassouza.pedidos.processador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;
import br.com.douglassouza.pedidos.processador.domain.model.Pedido;
import br.com.douglassouza.pedidos.processador.port.in.ItemPedidoServicePort;
import br.com.douglassouza.pedidos.processador.port.in.PedidoServicePort;
import br.com.douglassouza.pedidos.processador.port.in.ProdutoServicePort;
import br.com.douglassouza.pedidos.processador.port.out.PedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final ProdutoServicePort produtoServicePort;
    private final ItemPedidoServicePort itemPedidoServicePort;


    public void save(Pedido pedido) {
        log.info("Salvando pedido: {}", pedido.toString());


        // salvamos os produtos
        produtoServicePort.save(pedido.getItens());

        //salvamos os itens do pedido
        List<ItemPedido> listaItemPedidos = itemPedidoServicePort.save(pedido.getItens());

        pedidoRepositoryPort.save(pedido);

        // atualiza o item pedido definindo o pedido ao qual pertence.
        itemPedidoServicePort.updateItemPedido(listaItemPedidos, pedido);

        log.info("Pedido salvo com sucesso: {}", pedido.toString());
    }

}
