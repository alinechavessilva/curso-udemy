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

import com.br.cursoudemy.DTO.CategoriaDTO;
import com.br.cursoudemy.entities.Categoria;
import com.br.cursoudemy.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	@RequestMapping(value = "/")
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<CategoriaDTO> listaCategorias = categoriaService.findAll();
		
		return ResponseEntity.ok().body(listaCategorias);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Categoria>> find(@PathVariable Integer id) {
		
		 Optional<Categoria> categoria = categoriaService.find(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody CategoriaDTO categoriaDTO) { 
			 Categoria categoria = categoriaService.fromDTO(categoriaDTO);
		     categoria = categoriaService.insert(categoria);
		    
		    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		    			.path("/{id}").buildAndExpand(categoria.getId())
		    			.toUri();
		    
	       return ResponseEntity.created(uri).build();
	 }
	
	@PutMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Categoria> update (@Valid @PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO){
		 Categoria categoria = categoriaService.fromDTO(categoriaDTO);
		 categoria.setId(id);
		 
		 categoriaService.update(categoria);
		 
	    return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		 categoriaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	@RequestMapping(value = "/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
													@RequestParam(value = "page", defaultValue = "0") Integer page,
													@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
													@RequestParam(value = "ordeBy", defaultValue = "nome") String orderBy,
													@RequestParam(value = "direction", defaultValue = "ASC") String direction){
		Page<CategoriaDTO> listaCategorias = categoriaService.findPage(page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(listaCategorias);
		
	}
	
}
