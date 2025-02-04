package com.sesi.projeto.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sesi.projeto.dto.ProdutoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double preco;
	private String descricao;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name="tb_produto_categoria", joinColumns = @JoinColumn(name="produto_id"), 
	inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();
	
	
	@OneToMany(mappedBy="id.produto")
	private Set<ItemDoPedido> itens = new HashSet<>();
	
	public Set<ItemDoPedido> getItens(){
		return itens;
	}
	
	public List<Pedido>getPedido(){
		return itens.stream().map(x->x.getPedido()).toList();
	}
	//Construtor sem argumentos
		public Produto () {
			
		}
		
		public Produto (ProdutoDTO dto) {
			this.nome = dto.nome();
			this.preco = dto.preco();
			this.descricao = dto.descricao();
			this.imgUrl=dto.imgUrl();
		}
		
		//Construtor com argumentos
		public Produto(Long id, String nome, double preco, String descricao, String imgUrl) {
			this.id = id;
			this.nome = nome;
			this.preco = preco;
			this.descricao = descricao;
			this.imgUrl = imgUrl;
		}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgURL() {
		return imgUrl;
	}

	public void setImgURL(String imgURL) {
		this.imgUrl = imgURL;
	}
	
	
	
	
}
