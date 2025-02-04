package com.sesi.projeto.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sesi.projeto.dto.PedidoDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private statusDoPedido status;
	
	//cardinalidade- relacionamento das tabelas
	@ManyToOne
	@JoinColumn(name= "cliente_id")//chave estrangeira no BD
	private Usuario cliente;
	
	@OneToOne(mappedBy="pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemDoPedido>itens = new HashSet<>();
	
	public Set<ItemDoPedido>getItens(){
		return itens;
	}
	
	public List<Produto>getProduto(){
		return itens.stream().map(x->x.getProduto()).toList();
	}
	
	
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
