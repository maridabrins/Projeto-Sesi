package com.sesi.projeto.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_item")
public class ItemDoPedido {
	

	@EmbeddedId
	private ItemDoPedidoPK id = new ItemDoPedidoPK();
	private Integer quantidade;
	private double preco;
	
	public ItemDoPedido() {
	}
	
	
	public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public ItemDoPedidoPK getId() {
		return id;
	}


	public void setId(ItemDoPedidoPK id) {
		this.id = id;
	}

	public 	Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
		
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	public void setProduto(Produto produto) {
		id.setProduto(produto);
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
