package com.br.cursoudemy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Produto;
import com.br.cursoudemy.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		Produto produtoCreated = produtoRepository.save(produto);
		
		return produtoCreated;
	}
	
	public List listAll() {
		List produtos = produtoRepository.findAll();
		
		return produtos;
	}
	
	
}
