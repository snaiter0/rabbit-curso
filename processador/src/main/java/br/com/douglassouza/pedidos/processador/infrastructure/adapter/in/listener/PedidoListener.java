package br.com.douglassouza.pedidos.processador.infrastructure.adapter.in.listener;


import br.com.douglassouza.pedidos.processador.domain.model.Pedido;
import br.com.douglassouza.pedidos.processador.domain.model.enums.StatusEnum;
import br.com.douglassouza.pedidos.processador.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PedidoListener {

    private final PedidoService pedidoService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(Pedido pedido) {
        pedido.setStatus(StatusEnum.PROCESSADO);
        pedidoService.save(pedido);
    }
}
