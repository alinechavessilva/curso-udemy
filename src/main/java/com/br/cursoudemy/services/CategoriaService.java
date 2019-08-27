package com.br.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Categoria;
import com.br.cursoudemy.repositories.CategoriaRepository;
import com.br.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> find(Integer id)  {
	 Optional<Categoria> categoria = categoriaRepository.findById(id);
	 
	 if (!categoria.isPresent()) {
		 throw new ObjectNotFoundException("Objeto não encontrado : Id = "+ id + " , Tipo : " + Categoria.class.getName() );
	 }
		
	    return categoria; 
	}
	
	public Categoria insert(Categoria categoria) {
		return  categoriaRepository.save(categoria);
		 
	}
	
	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return categoriaRepository.save(categoria);
	}

}
