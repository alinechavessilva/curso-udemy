package com.br.cursoudemy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cursoudemy.DTO.ClienteDTO;
import com.br.cursoudemy.DTO.ClienteNewDTO;
import com.br.cursoudemy.entities.Cidade;
import com.br.cursoudemy.entities.Cliente;
import com.br.cursoudemy.entities.Endereco;
import com.br.cursoudemy.entities.enums.TipoCliente;
import com.br.cursoudemy.repositories.CidadeRepository;
import com.br.cursoudemy.repositories.ClienteRepository;
import com.br.cursoudemy.repositories.EnderecoRepository;
import com.br.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<ClienteDTO> findAll(){
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ClienteDTO> listDTO = listaCliente.stream().
										map(obj-> new ClienteDTO(obj)).collect(Collectors.toList());
		
		return listDTO;
	}
	
	public Optional<Cliente> find(Integer id)  {
	 Optional<Cliente> cliente = clienteRepository.findById(id);
	 
	 if (!cliente.isPresent()) {
		 throw new ObjectNotFoundException("Objeto não encontrado : Id = "+ id + " , Tipo : " + Cliente.class.getName() );
	 }
		
	    return cliente; 
	}
	
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteRepository.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return cliente;
	}
	
	public Cliente update(Cliente cliente) {
		Optional<Cliente> clienteResult = find(cliente.getId());
		updateData(clienteResult, cliente);
		return clienteRepository.save(clienteResult.get());
	}
	
	public void delete(Integer id) {
		find(id);
		clienteRepository.deleteById(id);
	}
	

	public Page<ClienteDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){	
		 PageRequest pageRequest =  PageRequest.of(page, linesPerPage,Direction.valueOf( direction), orderBy);
		 Page<Cliente> listaCliente = clienteRepository.findAll(pageRequest);
		 Page<ClienteDTO> listDTO = listaCliente.map(obj-> new ClienteDTO(obj));
		 
		return listDTO;
	}
	
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO);
	}
	
	public Cliente fromDTO(ClienteNewDTO clienteNewDTO) {
		Cliente cliente = new Cliente(null, clienteNewDTO.getNome(), clienteNewDTO.getEmail(), clienteNewDTO.getCpfOuCnpj(), 
											TipoCliente.toEnum(clienteNewDTO.getTipocliente()));
		
		Cidade cidade = new Cidade(clienteNewDTO.getCidadeId(), null, null);
		
		Endereco endereco = new Endereco(null, clienteNewDTO.getLogradouro(), clienteNewDTO.getNumero(), clienteNewDTO.getComplemento(), 
											 clienteNewDTO.getBairro(), clienteNewDTO.getCep(), cidade, cliente);
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(clienteNewDTO.getTelefone1());
		if(clienteNewDTO.getTelefone2() != null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefone2());
		}
		
		if(clienteNewDTO.getTelefone3() != null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefone3());
		}
		return cliente;
	}
	
	public void updateData(Optional<Cliente> clienteResult, Cliente cliente) {
		clienteResult.get().setNome(cliente.getNome());
		clienteResult.get().setEmail(cliente.getEmail());
	}
}
