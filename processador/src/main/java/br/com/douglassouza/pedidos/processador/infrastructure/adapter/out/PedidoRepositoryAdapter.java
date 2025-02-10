package br.com.douglassouza.pedidos.processador.infrastructure.adapter.out;

import br.com.douglassouza.pedidos.processador.domain.model.Pedido;
import br.com.douglassouza.pedidos.processador.infrastructure.repository.PedidoRepository;
import br.com.douglassouza.pedidos.processador.port.out.PedidoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {
    private final PedidoRepository pedidoRepository;


    @Override
    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
