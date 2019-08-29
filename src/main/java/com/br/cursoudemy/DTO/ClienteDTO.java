package com.br.cursoudemy.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.br.cursoudemy.entities.Cliente;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String  nome;
	
	@NotEmpty(message = "Não pode ser vazio")
	@Email(message = "Email inválido")
	private String  email;
	
	public ClienteDTO() {}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
