package com.sesi.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projeto.dto.ProdutoDTO;
import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.repositories.ProdutoRepository;

@RestController
@RequestMapping(value ="produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;
	
	@GetMapping
	//responseEntity é uma classe que representa a resposta HTTP
	//List<Produto> indica que o corpo da resposta será uma lista de objetos do tipo Produto
	
	public ResponseEntity<List<Produto>> mostrarTodos(){ 
		List<Produto> prod = repository.findAll(); //A variável prod é uma lista que vai armazenar os objetos Produto
		//findAll() é usado para buscar todos os registros da tabela no banco de dados
		return ResponseEntity.ok(prod); //retorna uma resposta HTTP de sucesso (status 200 OK) com o corpo sendo a lista prod, que contém todos os produtos. 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Produto prod = repository.getById(id);
		return ResponseEntity.ok(prod);
	}
	
	@PostMapping("")
	public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO dto){
		Produto prod = new Produto(dto);
		return ResponseEntity.ok(prod);
		
	}
}
