package br.com.api.atividade.pid.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Categoria de Produtos", description = "API para realizar cadastro de categorias de produtos")
public class CatProdutoModel {

	private Integer id;

	private String categoria;

	@ApiModelProperty(value = "ID da Categoria do Produto", name = "Id", position = 1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ApiModelProperty(value = "Nome da Categoria do Produto", name = "Categoria", position = 2, required = true)
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "CatProdutoModel [id=" + id + ", categoria=" + categoria + "]";
	}

	public CatProdutoModel(Integer id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	public CatProdutoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
