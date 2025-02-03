package com.sesi.projeto.dto;

public record UsuarioDTO(Long id, String nome, String email, String telefone, String senha, String[] roles) {

}
