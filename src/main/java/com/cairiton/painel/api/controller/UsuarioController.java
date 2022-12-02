package com.cairiton.painel.api.controller;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.painel.model.Usuario;

@RestController
public class UsuarioController {
	
	@GetMapping("/usuarios")
	public List<Usuario> listar (){
		
		Usuario usuario1 = new Usuario();
		usuario1.setId(1L);
		usuario1.setNome("joao");
		usuario1.setEmail("joao@gmail.com");
		usuario1.setSenha("123456");
		usuario1.setTelefone("62 91111-1111");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);
		usuario2.setNome("bastiao");
		usuario2.setEmail("bastiao@gmail.com");
		usuario2.setSenha("123456");
		usuario2.setTelefone("62 92222-2222");
		
		return Arrays.asList(usuario1, usuario2);
	}

	
}
