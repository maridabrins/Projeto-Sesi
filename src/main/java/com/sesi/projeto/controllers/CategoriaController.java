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

import com.sesi.projeto.dto.CategoriaDTO;
import com.sesi.projeto.entities.Categoria;
import com.sesi.projeto.repositories.CategoriaRepository;

@RestController
@RequestMapping(value ="categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> mostrarTodos(){ 
		List<Categoria> categoria = repository.findAll(); 
		return ResponseEntity.ok(categoria); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Categoria categoria = repository.getById(id);
		return ResponseEntity.ok(categoria);
	}
	
	@PostMapping("")
	public ResponseEntity<Categoria> criar(@RequestBody CategoriaDTO dto){
		Categoria categoria = new Categoria(dto);
		return ResponseEntity.ok(categoria);
		
	}

}
