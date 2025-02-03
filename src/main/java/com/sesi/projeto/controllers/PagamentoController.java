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

import com.sesi.projeto.dto.PagamentoDTO;
import com.sesi.projeto.entities.Pagamento;
import com.sesi.projeto.repositories.PagamentoRepository;



@RestController
@RequestMapping(value ="pagamento")
public class PagamentoController {
	
	@Autowired
	PagamentoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> mostrarTodos(){ 
		List<Pagamento> pagamento = repository.findAll(); 
		return ResponseEntity.ok(pagamento); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Pagamento pagamento = repository.getById(id);
		return ResponseEntity.ok(pagamento);
	}
	
	@PostMapping("")
	public ResponseEntity<Pagamento> criar(@RequestBody PagamentoDTO dto){
		Pagamento pagamento = new Pagamento(dto);
		return ResponseEntity.ok(pagamento);
		
	}

}
