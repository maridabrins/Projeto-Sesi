package com.sesi.projeto.entities;

import com.sesi.projeto.dto.ItemDoPedidoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itens")
public class ItemDoPedido {
	
	private Long id;
	private Integer quantidade;
	private double preco;
	
	public ItemDoPedido() {
		
	}
	
	public ItemDoPedido(ItemDoPedidoDTO dto) {
		this.quantidade = dto.quantidade();
		this.preco = dto.preco();
	}
	
	public ItemDoPedido(Integer quantidade, double preco) {
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	

}
