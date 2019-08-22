package com.br.cursoudemy.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity findOne (@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteService.findOne(id);
		
		return ResponseEntity.ok().body(cliente);
	}
}
