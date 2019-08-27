package com.br.cursoudemy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.cursoudemy.DTO.CategoriaDTO;
import com.br.cursoudemy.entities.Categoria;
import com.br.cursoudemy.repositories.CategoriaRepository;
import com.br.cursoudemy.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<CategoriaDTO> findAll(){
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		List<CategoriaDTO> listDTO = listaCategoria.stream().
										map(obj-> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		return listDTO;
	}
	
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
	
	public void delete(Integer id) {
		find(id);
		categoriaRepository.deleteById(id);
	}
	

	public Page<CategoriaDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){	
		 PageRequest pageRequest =  PageRequest.of(page, linesPerPage,Direction.valueOf( direction), orderBy);
		 Page<Categoria> listaCategoria = categoriaRepository.findAll(pageRequest);
		 Page<CategoriaDTO> listDTO = listaCategoria.map(obj-> new CategoriaDTO(obj));
		 
		return listDTO;
	}
	
	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
	}

}
