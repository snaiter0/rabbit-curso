package br.com.douglassouza.pedidos.processador.port.in;

import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;

import java.util.List;

public interface ProdutoServicePort {


    void save(List<ItemPedido> itens);
}
