package br.com.api.atividade.pid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TbCidade {

	@Id
	private Integer codigo;

	private String cidade;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "CidadeModel [codigo=" + codigo + ", cidade=" + cidade + "]";
	}

	public TbCidade(Integer codigo, String cidade) {
		super();
		this.codigo = codigo;
		this.cidade = cidade;
	}

	public TbCidade() {
		super();
		// TODO Auto-generated constructor stub
	}

}
