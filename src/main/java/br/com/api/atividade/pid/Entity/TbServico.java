package br.com.api.atividade.pid.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TbServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String servico;
	private String jornada;
	private String descricao;
	private String custo;
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
		return "TbServico [id=" + id + ", servico=" + servico + ", jornada=" + jornada + ", descricao=" + descricao
				+ ", custo=" + custo + ", modelo=" + modelo + "]";
	}

	public TbServico(Integer id, String servico, String jornada, String descricao, String custo, String modelo) {
		super();
		this.id = id;
		this.servico = servico;
		this.jornada = jornada;
		this.descricao = descricao;
		this.custo = custo;
		this.modelo = modelo;
	}

	public TbServico() {
		super();
		// TODO Auto-generated constructor stub
	}

}
