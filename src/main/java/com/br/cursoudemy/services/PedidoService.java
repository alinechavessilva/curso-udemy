package com.br.cursoudemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.entities.Pedido;
import com.br.cursoudemy.repositories.PedidoRepository;
import com.br.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
   @Autowired
   private PedidoRepository pedidoRepository;
   
   public Optional<Pedido> find(Integer id){
	   Optional<Pedido> pedido = pedidoRepository.findById(id);
	   
	   if (!pedido.isPresent()) {
			 throw new ObjectNotFoundException("Objeto não encontrado : Id = "+ id + " , Tipo : " + Pedido.class.getName() );
		 }
	   
	   return pedido;
   }
   
   
}
