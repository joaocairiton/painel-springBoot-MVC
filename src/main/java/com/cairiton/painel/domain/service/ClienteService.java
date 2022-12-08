package com.cairiton.painel.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cairiton.painel.domain.exception.DomainException;
import com.cairiton.painel.domain.repository.ClienteRepository;
import com.cairiton.painel.model.Cliente;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		
  boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
		  .stream()
		  .anyMatch(usuarioExistente -> !usuarioExistente.equals(cliente));
  
  if (emailEmUso) {
	  throw new DomainException("Este E-mail já Existe.");
	
}
		
		
		return clienteRepository.save(cliente);
		
	}
	
	
	@Transactional
	public void excluir(Long usuarioId) {
		
		clienteRepository.deleteById(usuarioId);
	}

}
