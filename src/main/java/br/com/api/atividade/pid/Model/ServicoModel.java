package br.com.api.atividade.pid.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Serviços", description = "API para realizar registro de serviços")
public class ServicoModel {

	@ApiModelProperty(value = "Id de Serviços", name = "Id")
	private Integer id;
	@ApiModelProperty(value = "Nome do Serviço", name = "Serviço", required = true)
	private String servico;
	@ApiModelProperty(value = "Tipo de Jornada", name = "Jornada", required = true)
	private String jornada;
	@ApiModelProperty(value = "Descrição do Serviço", name = "Descrição", required = true)
	private String descricao;
	@ApiModelProperty(value = "Custo do Serviço", name = "Custo", required = true)
	private String custo;
	@ApiModelProperty(value = "Modelo do Serviço", name = "Modelo", required = true)
	private String modelo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCusto() {
		return custo;
	}

	public void setCusto(String custo) {
		this.custo = custo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "ServicoModel [id=" + id + ", servico=" + servico + ", jornada=" + jornada + ", descricao=" + descricao
				+ ", custo=" + custo + ", modelo=" + modelo + "]";
	}

	public ServicoModel(Integer id, String servico, String jornada, String descricao, String custo, String modelo) {
		super();
		this.id = id;
		this.servico = servico;
		this.jornada = jornada;
		this.descricao = descricao;
		this.custo = custo;
		this.modelo = modelo;
	}

	public ServicoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
