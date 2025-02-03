package com.sesi.projeto.entities;

import java.time.Instant;

import com.sesi.projeto.dto.PedidoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private statusDoPedido status;
	
	public Pedido() {
		
	}
	
	public Pedido(PedidoDTO dto) {
		this.momento = dto.momento();
		this.status = dto.status();
		
	}

	public Pedido(Long id, Instant momento, statusDoPedido status) {
		this.id = id;
		this.momento = momento;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public statusDoPedido getStatus() {
		return status;
	}

	public void setStatus(statusDoPedido status) {
		this.status = status;
	}
	
	
	

}
