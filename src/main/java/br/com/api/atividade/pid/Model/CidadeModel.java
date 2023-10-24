package br.com.api.atividade.pid.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Cidade", description = "API para realizar cadastro de cidade")
public class CidadeModel {

	@ApiModelProperty(value = "Codigo da Cidade", name = "Codigo", dataType = "Integer", required = true)
	private Integer codigo;

	@ApiModelProperty(value = "Nome da Cidade", name = "Cidade", dataType = "String", required = true)
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

	public CidadeModel(Integer codigo, String cidade) {
		super();
		this.codigo = codigo;
		this.cidade = cidade;
	}

	public CidadeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
