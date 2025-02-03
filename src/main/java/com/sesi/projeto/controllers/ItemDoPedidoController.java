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

import com.sesi.projeto.dto.ItemDoPedidoDTO;
import com.sesi.projeto.entities.ItemDoPedido;
import com.sesi.projeto.repositories.ItemDoPedidoRepository;



@RestController
@RequestMapping(value ="itens")
public class ItemDoPedidoController {
	
	@Autowired
	ItemDoPedidoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ItemDoPedido>> mostrarTodos(){ 
		List<ItemDoPedido> item = repository.findAll(); 
		return ResponseEntity.ok(item); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		ItemDoPedido item = repository.getById(id);
		return ResponseEntity.ok(item);
	}
	
	@PostMapping("")
	public ResponseEntity<ItemDoPedido> criar(@RequestBody ItemDoPedidoDTO dto){
		ItemDoPedido item = new ItemDoPedido(dto);
		return ResponseEntity.ok(item);
		
	}

}
