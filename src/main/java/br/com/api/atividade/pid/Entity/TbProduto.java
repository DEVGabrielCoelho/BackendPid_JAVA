package br.com.api.atividade.pid.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TbProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String metrica;
	private String descricao;
	private Integer categoria;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMetrica() {
		return metrica;
	}

	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "TbProduto [codigo=" + codigo + ", nome=" + nome + ", metrica=" + metrica + ", descricao=" + descricao
				+ ", categoria=" + categoria + "]";
	}

	public TbProduto(Integer codigo, String nome, String metrica, String descricao, Integer categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.metrica = metrica;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public TbProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
