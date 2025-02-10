package br.com.douglassouza.pedidos.processador.domain.model;


import br.com.douglassouza.pedidos.processador.domain.model.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    private UUID id= UUID.randomUUID();

    private String cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @Column(name="valor_total")
    private Double valorTotal;

    @Column(name="valor_notificacao")
    private String emailNotificacao;

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.EM_PROCESSAMENTO;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();
}
