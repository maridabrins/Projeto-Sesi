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

import com.sesi.projeto.dto.UsuarioDTO;
import com.sesi.projeto.entities.Usuario;
import com.sesi.projeto.repositories.UsuarioRepository;

@RestController
@RequestMapping(value ="usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> mostrarTodos(){ 
		List<Usuario> user = repository.findAll(); 
		return ResponseEntity.ok(user); 
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
		Usuario user = repository.getById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("")
	public ResponseEntity<Usuario> criar(@RequestBody UsuarioDTO dto){
		Usuario user = new Usuario(dto);
		return ResponseEntity.ok(user);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> editar(@PathVariable Long id, @RequestBody UsuarioDTO dto){
		Optional<Usuario> usuarioExistente = repository.findById(id);
		if(!usuarioExistente.isPresent()) {
			  Usuario editarUser = usuarioExistente.get();
			  editarUser.setNome(dto.nome());
			  editarUser.setEmail(dto.email());
			  editarUser.setTelefone(dto.telefone());
			  editarUser.setSenha(dto.senha());
			  editarUser.setRoles(dto.roles());
			  
			  repository.save(editarUser);
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
