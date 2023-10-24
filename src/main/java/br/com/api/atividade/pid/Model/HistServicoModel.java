package br.com.api.atividade.pid.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Histórico de Serviços", description = "API para realizar registro de serviços prestados na empresa.")
public class HistServicoModel {

	@ApiModelProperty(value = "Id do Histórico de Serviços", name = "Id", dataType = "Integer")
	private Integer id;
	@ApiModelProperty(value = "CPF do Prestador", name = "CPF", dataType = "Long", required = true)
	private Long prestador;
	@ApiModelProperty(value = "Código do Serviço", name = "Código", dataType = "Integer", required = true)
	private Integer servico;
	@ApiModelProperty(value = "Data do serviço prestado no formato 00/00/0000", name = "Data", dataType = "Date", required = true)
	private Date serviceData;
	@ApiModelProperty(value = "Valor do Serviço prestado", name = "Valor", dataType = "String", required = true)
	private String valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPrestador() {
		return prestador;
	}

	public void setPrestador(Long prestador) {
		this.prestador = prestador;
	}

	public Integer getServico() {
		return servico;
	}

	public void setServico(Integer servico) {
		this.servico = servico;
	}

	public Date getServiceData() {
		return serviceData;
	}

	public void setServiceData(Date serviceData) {
		this.serviceData = serviceData;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "HistServicoModel [id=" + id + ", prestador=" + prestador + ", servico=" + servico + ", serviceData="
				+ serviceData + ", valor=" + valor + "]";
	}

	public HistServicoModel(Integer id, Long prestador, Integer servico, Date serviceData, String valor) {
		super();
		this.id = id;
		this.prestador = prestador;
		this.servico = servico;
		this.serviceData = serviceData;
		this.valor = valor;
	}

	public HistServicoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
