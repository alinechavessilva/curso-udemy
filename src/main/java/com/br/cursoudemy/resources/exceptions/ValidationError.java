package com.br.cursoudemy.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> listErros = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}
	
	public List<FieldMessage> getErros(){
		return listErros;
	}

	public void addError(String fieldName, String name) {
		listErros.add(new FieldMessage(fieldName, name));
	}
}
