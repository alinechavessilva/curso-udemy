package com.br.cursoudemy.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.cursoudemy.entities.Categoria;
import com.br.cursoudemy.services.CategoriaService;

@RestController
@RequestMapping(value="categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		 Optional<Categoria> categoria = categoriaService.buscarPorId(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	   @PostMapping
	  public ResponseEntity<?> criar(@RequestBody Categoria categoria) { 
		   
		    Categoria categoriaCreated = categoriaService.salvar(categoria);
	  
	       return ResponseEntity.ok().body(categoriaCreated);
	  }
	 
}
