package com.br.cursoudemy.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cursoudemy.entities.Pedido;
import com.br.cursoudemy.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Pedido>> findById(@PathVariable Integer id){
		
		Optional<Pedido> pedido = pedidoService.find(id);
		
		return ResponseEntity.ok().body(pedido);
	}

}
