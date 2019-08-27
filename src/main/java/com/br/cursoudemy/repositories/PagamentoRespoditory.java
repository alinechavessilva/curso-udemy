package com.br.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cursoudemy.entities.Pagamento;

@Repository
public interface PagamentoRespoditory extends JpaRepository<Pagamento, Integer> {

}
