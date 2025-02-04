package com.sesi.projeto.entities;


import java.util.ArrayList;
import java.util.List;

import com.sesi.projeto.dto.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private String[] roles;
	
	//criando uma lista de pedidos do usuario
	@OneToMany(mappedBy= "cliente")//referenciado da entidade Pedido
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Usuario() {
		
	}
	
	public Usuario(UsuarioDTO dto) {

		this.nome = dto.nome();
		this.email = dto.email();
		this.telefone = dto.telefone();
		this.senha = dto.senha();
		this.roles = dto.roles();
	}

	public Usuario(Long id, String nome, String email, String telefone, String senha, String[] roles) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	 
	
}
