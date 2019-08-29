package com.br.cursoudemy.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.br.cursoudemy.services.validation.ClienteInsert;


@ClienteInsert
public class ClienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Cpf ou cnpj não pode ser vazio")
	private String cpfOuCnpj;
	
	private Integer tipocliente;
	
	private String logradouro;
	
	@NotEmpty(message = "Numero não pode ser vazio")
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotEmpty(message = "Cep não pode ser vazio")
	private String cep;
	
	
	@NotEmpty(message = "Telefone não pode ser vazio")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer cidadeId;
	
	public ClienteNewDTO() {}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public Integer getTipocliente() {
		return tipocliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}
	
	

}
