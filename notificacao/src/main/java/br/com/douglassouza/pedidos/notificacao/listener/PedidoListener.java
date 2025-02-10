package br.com.douglassouza.pedidos.notificacao.listener;

import br.com.douglassouza.pedidos.notificacao.entity.Pedido;
import br.com.douglassouza.pedidos.notificacao.service.Emailservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoListener {

    private final Emailservice emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){

        log.info("Tentativa de consumo da mensagem");

        if(pedido.getValorTotal()>2000){
            throw new RuntimeException("Valor muito alto.");
        }

        emailService.enviarEmail(pedido);
        log.info("Notificacao gerada: {}", pedido.toString());
    }


}
