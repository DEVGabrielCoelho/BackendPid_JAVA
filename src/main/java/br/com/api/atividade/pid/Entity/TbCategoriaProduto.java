package br.com.api.atividade.pid.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TbCategoriaProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String categoria;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "TbCategoriaProduto [codigo=" + codigo + ", categoria=" + categoria + "]";
	}

	public TbCategoriaProduto(Integer codigo, String categoria) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
	}

	public TbCategoriaProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
