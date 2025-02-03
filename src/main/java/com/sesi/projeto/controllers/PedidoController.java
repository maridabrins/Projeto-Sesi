package com.sesi.projeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.projeto.dto.PedidoDTO;
import com.sesi.projeto.entities.Pedido;
import com.sesi.projeto.repositories.PedidoRepository;

@RestController
@RequestMapping(value ="pedido")
public class PedidoController {
	
	@Autowired
	PedidoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> mostrarTodos(){ 
		List<Pedido> pedido = repository.findAll(); 
		return ResponseEntity.ok(pedido); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Pedido pedido = repository.getById(id);
		return ResponseEntity.ok(pedido);
	}
	
	@PostMapping("")
	public ResponseEntity<Pedido> criar(@RequestBody PedidoDTO dto){
		Pedido pedido = new Pedido(dto);
		return ResponseEntity.ok(pedido);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> editar(@PathVariable Long id, @RequestBody PedidoDTO dto){
		Optional<Pedido> pedidoExistente = repository.findById(id);
		if(!pedidoExistente.isPresent()) {
			  Pedido editarPedido = pedidoExistente.get();
			  editarPedido.setMomento(dto.momento());
			  editarPedido.setStatus(dto.status());
			 
			  
			  repository.save(editarPedido);
			  return ResponseEntity.ok().build();
		} else return ResponseEntity.notFound().build();
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}else return ResponseEntity.notFound().build();
	}
	
	

}
