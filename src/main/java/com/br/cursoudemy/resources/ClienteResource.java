package com.br.cursoudemy.resources;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Cliente>> find(@PathVariable Integer id) {
		
		 Optional<Cliente> cliente = clienteService.find(id);
		
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente) { 

		     cliente = clienteService.create(cliente);
		    
		    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		    			.path("/{id}").buildAndExpand(cliente.getId())
		    			.toUri();
		    
	       return ResponseEntity.created(uri).build();
	 }
	
	@PutMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody Cliente cliente){
				 		 		 
		 cliente.setId(id);
		 
		Cliente clienteResult = clienteService.update(cliente);
		 
	    return ResponseEntity.noContent().build();
	}
	
}
