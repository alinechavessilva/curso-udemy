package com.br.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Optional<Cliente> findOne(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		return cliente;
	}
}
