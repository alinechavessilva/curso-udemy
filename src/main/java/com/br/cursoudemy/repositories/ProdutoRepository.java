package com.br.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cursoudemy.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
