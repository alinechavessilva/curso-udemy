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

import com.br.cursoudemy.entities.Categoria;
import com.br.cursoudemy.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		 Optional<Categoria> categoria = categoriaService.find(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Categoria categoria) { 

		     categoria = categoriaService.insert(categoria);
		    
		    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		    			.path("/{id}").buildAndExpand(categoria.getId())
		    			.toUri();
		    
	       return ResponseEntity.created(uri).build();
	 }
	
	@PutMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody Categoria categoria){
				 		 		 
		 categoria.setId(id);
		 
		Categoria categoriaResult = categoriaService.update(categoria);
		 
	    return ResponseEntity.noContent().build();
	}
	
	 
}
