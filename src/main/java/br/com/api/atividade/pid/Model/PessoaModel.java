package br.com.api.atividade.pid.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Pessoas", description = "API para realizar cadastro de pessoas")
public class PessoaModel {

	@ApiModelProperty(value = "CPF do Prestador", name = "CPF", required = true)
	private Long cpf;
	@ApiModelProperty(value = "Nome da pessoa", name = "Nome", required = true)
	private String nome;
	@ApiModelProperty(value = "Data de nascimento (00/00/0000)", name = "Data Nascimento", required = true)
	@JsonFormat(pattern = "dd-mm-yyyy")
	private LocalDate nascimento;
	@ApiModelProperty(value = "Endereço da moradia", name = "Endereço", required = true)
	private String endereco;
	@ApiModelProperty(value = "Cidade onde Reside", name = "Cidade", required = true)
	private Integer cidade;
	@ApiModelProperty(value = "Telefone para Contato", name = "Telefone")
	private String telefone;
	@ApiModelProperty(value = "E-mail para contato", name = "E-mail", required = true)
	private String email;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PessoaModel [cpf=" + cpf + ", nome=" + nome + ", nascimento=" + nascimento + ", endereco=" + endereco
				+ ", cidade=" + cidade + ", telefone=" + telefone + ", email=" + email + "]";
	}

	public PessoaModel(Long cpf, String nome, LocalDate nascimento, String endereco, Integer cidade, String telefone,
			String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.telefone = telefone;
		this.email = email;
	}

	public PessoaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
