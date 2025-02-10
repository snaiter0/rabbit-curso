package br.com.douglassouza.pedidos.processador.service;


import br.com.douglassouza.pedidos.processador.domain.model.ItemPedido;
import br.com.douglassouza.pedidos.processador.port.in.ProdutoServicePort;
import br.com.douglassouza.pedidos.processador.port.out.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    @Override
    public void save(List<ItemPedido> itens) {

        itens.forEach(item -> {
            produtoRepositoryPort.save(item.getProduto());
        });
    }

}
