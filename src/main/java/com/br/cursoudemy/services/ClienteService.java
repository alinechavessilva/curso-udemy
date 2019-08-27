package com.br.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.repositories.ClienteRepository;
import com.br.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Optional<Cliente> find(Integer id)  {
	 Optional<Cliente> cliente = clienteRepository.findById(id);
	 
	 if (!cliente.isPresent()) {
		 throw new ObjectNotFoundException("Objeto não encontrado : Id = "+ id + " , Tipo : " + Cliente.class.getName() );
	 }
		
	    return cliente; 
	}
	
	public Cliente create(Cliente cliente) {
		 Cliente clienteCreated = clienteRepository.save(cliente);
		 
		 return clienteCreated;
	}
	
	public Cliente update(Cliente cliente) {
		find(cliente.getId());
		return clienteRepository.save(cliente);
	}
}
