package com.cairiton.painel.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
