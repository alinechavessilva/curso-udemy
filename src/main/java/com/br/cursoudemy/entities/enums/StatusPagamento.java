package com.br.cursoudemy.entities.enums;

public enum StatusPagamento {
		PENDENTE(1,"Pagamento pendente"),
		QUITADO(2,"Pagamento quitado"),
		CANCELADO(3,"Pagamento cancelado");
	
	  private Integer codigo;
	  private String descricao;
	  
	  private StatusPagamento(Integer codigo, String descricao) {
		  this.codigo = codigo;
		  this.descricao = descricao;
	  }

	  public Integer getCodigo() {
			return codigo;
		}

		public void setCodigo(Integer codigo) {
			this.codigo = codigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		public static StatusPagamento toEnum(Integer codigo) {
			if (codigo == null) {
				return null;
			}
			
			for (StatusPagamento statusPagamento : StatusPagamento.values()) {
				if(codigo.equals(statusPagamento.getCodigo())) {
					return statusPagamento;
				}
				
			}
			
			throw new  IllegalArgumentException("Id inválido : " + codigo);
		}
	  
}
