package br.com.douglassouza.pedidos.notificacao.service;

import br.com.douglassouza.pedidos.notificacao.entity.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Emailservice {

    private final JavaMailSender javaMailSender;
    private final JavaMailSenderImpl mailSender;

    public void enviarEmail(Pedido pedido) {
         SimpleMailMessage message = new SimpleMailMessage();

         message.setFrom("pedidos-api@company.com");
         message.setTo(pedido.getEmailNotificacao());
         message.setSubject("Pedido de compra");
         message.setText(gerarMessagem(pedido));
         mailSender.send(message);
     }


     private String gerarMessagem(Pedido pedido){
         String pedidoId = pedido.getId().toString();
         String cliente = pedido.getCliente();
         String valorTotal = String.valueOf(pedido.getValorTotal());
         String status = pedido.getStatus().name();

         return String.format("Olá %s seu pedido de nº %s no valor de: R$%s, foi realizado com sucesso. \nStatus: %s.", cliente, pedidoId, valorTotal, status);
     }
}
