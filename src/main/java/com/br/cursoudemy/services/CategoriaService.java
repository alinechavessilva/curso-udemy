package com.br.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Categoria;
import com.br.cursoudemy.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> buscarPorId(Integer id) {
	 Optional<Categoria> categoria = categoriaRepository.findById(id);
		
	    return categoria; 
	}
	
	public Categoria salvar(Categoria categoria) {
		 Categoria categoriaCreted = categoriaRepository.save(categoria);
		 
		 return categoriaCreted;
	}

}
