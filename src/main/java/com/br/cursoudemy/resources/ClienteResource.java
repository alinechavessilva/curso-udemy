package com.br.cursoudemy.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.cursoudemy.DTO.ClienteDTO;
import com.br.cursoudemy.DTO.ClienteNewDTO;
import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<ClienteDTO> listaClientes = clienteService.findAll();
		
		return ResponseEntity.ok().body(listaClientes);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Cliente>> find(@PathVariable Integer id) {
		
		 Optional<Cliente> cliente = clienteService.find(id);
		
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO clienteNewDTO) { 
			 Cliente cliente = clienteService.fromDTO(clienteNewDTO);
		     cliente = clienteService.insert(cliente);
		    
		    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		    			.path("/{id}").buildAndExpand(cliente.getId())
		    			.toUri();
		    
	       return ResponseEntity.created(uri).build();
	 }
	
	@PutMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody Cliente cliente){
				 		 		 
		 cliente.setId(id);
		 clienteService.update(cliente);
		 
	    return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		 clienteService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	@RequestMapping(value = "/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
													@RequestParam(value = "page", defaultValue = "0") Integer page,
													@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
													@RequestParam(value = "ordeBy", defaultValue = "nome") String orderBy,
													@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		Page<ClienteDTO> listaClientes = clienteService.findPage(page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(listaClientes);
		
	}
	
}
