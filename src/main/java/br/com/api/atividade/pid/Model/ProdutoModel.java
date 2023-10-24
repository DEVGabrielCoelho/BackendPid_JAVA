package br.com.api.atividade.pid.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Produto", description = "API para realizar registro de produto")
public class ProdutoModel {

	@ApiModelProperty(value = "Codigo do Produto", name = "Codigo", dataType = "Integer")
	private Integer codigo;
	@ApiModelProperty(value = "Nome do Produto", name = "Nome", dataType = "String", required = true)
	private String nome;
	@ApiModelProperty(value = "Metrica do Produto", name = "Métrica", dataType = "String", required = true)
	private String metrica;
	@ApiModelProperty(value = "Descrição do Produto", name = "Descrição", dataType = "String", required = true)
	private String descricao;
	@ApiModelProperty(value = "Categoria do Produto", name = "Categoria", dataType = "Integer", required = true)
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
		return "ProdutoModel [codigo=" + codigo + ", nome=" + nome + ", metrica=" + metrica + ", descricao=" + descricao
				+ ", categoria=" + categoria + "]";
	}

	public ProdutoModel(Integer codigo, String nome, String metrica, String descricao, Integer categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.metrica = metrica;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public ProdutoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
