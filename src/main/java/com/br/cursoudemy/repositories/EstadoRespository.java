package com.br.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cursoudemy.entities.Estado;

@Repository
public interface EstadoRespository extends JpaRepository<Estado, Integer> {

}
