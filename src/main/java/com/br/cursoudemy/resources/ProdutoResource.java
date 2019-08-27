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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.cursoudemy.entities.Produto;
import com.br.cursoudemy.services.ProdutoService;

public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		 Optional<Produto> produto = produtoService.find(id);
		
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Produto produto) { 

		     produto = produtoService.create(produto);
		    
		    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		    			.path("/{id}").buildAndExpand(produto.getId())
		    			.toUri();
		    
	       return ResponseEntity.created(uri).build();
	 }
	
	@PutMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody Produto produto){
				 		 		 
		 produto.setId(id);
		 
		Produto produtoResult = produtoService.update(produto);
		 
	    return ResponseEntity.noContent().build();
	}
}
