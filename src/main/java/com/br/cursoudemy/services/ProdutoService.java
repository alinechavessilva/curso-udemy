package com.br.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Produto;
import com.br.cursoudemy.repositories.ProdutoRepository;
import com.br.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Optional<Produto> find(Integer id)  {
	 Optional<Produto> produto = produtoRepository.findById(id);
	 
	 if (!produto.isPresent()) {
		 throw new ObjectNotFoundException("Objeto não encontrado : Id = "+ id + " , Tipo : " + Produto.class.getName() );
	 }
		
	    return produto; 
	}
	
	public Produto create(Produto produto) {
		 Produto produtoCreated = produtoRepository.save(produto);
		 
		 return produtoCreated;
	}
	
	public Produto update(Produto produto) {
		find(produto.getId());
		return produtoRepository.save(produto);
	}
	
}
