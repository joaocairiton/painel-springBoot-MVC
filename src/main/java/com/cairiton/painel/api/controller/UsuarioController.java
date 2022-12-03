package com.cairiton.painel.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.painel.domain.repository.UsuarioRepository;
import com.cairiton.painel.model.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				// .map(usuario -> ResponseEntity.ok(usuario))
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

		/*
		 * Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		 * 
		 * if (usuario.isPresent()) { return ResponseEntity.ok(usuario.get()); }
		 * 
		 * return ResponseEntity.notFound().build();
		 */
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);

	}
	
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> atualizar (@PathVariable Long usuarioId,@RequestBody  Usuario usuario) {
		
		if (!usuarioRepository.existsById(usuarioId)) {
			return ResponseEntity.notFound().build();
			
		}
		usuario.setId(usuarioId);
		usuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuario);
		
	}

}
