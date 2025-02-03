package com.sesi.projeto.dto;

import java.time.Instant;

import com.sesi.projeto.entities.statusDoPedido;

public record PedidoDTO(Long id, Instant momento, statusDoPedido status) {

}
