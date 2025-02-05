package br.com.douglassouza.pedidos.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    private UUID id = UUID.randomUUID();

    private Double valor;

    private String nome;

}
