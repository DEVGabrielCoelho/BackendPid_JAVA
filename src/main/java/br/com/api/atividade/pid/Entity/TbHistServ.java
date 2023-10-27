package br.com.api.atividade.pid.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TbHistServ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long prestador;
	private Integer servico;
	private Date serviceData;
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
		return "TbHistServ [id=" + id + ", prestador=" + prestador + ", servico=" + servico + ", serviceData="
				+ serviceData + ", valor=" + valor + "]";
	}

	public TbHistServ(Integer id, Long prestador, Integer servico, Date serviceData, String valor) {
		super();
		this.id = id;
		this.prestador = prestador;
		this.servico = servico;
		this.serviceData = serviceData;
		this.valor = valor;
	}

	public TbHistServ() {
		super();
		// TODO Auto-generated constructor stub
	}

}
