package br.com.api.atividade.pid.Model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PID - Pessoas", description = "API para realizar cadastro de pessoas")
public class PessoaModel {

	@ApiModelProperty(value = "CPF do Prestador", name = "CPF", dataType = "Long", required = true)
	private Long cpf;
	@ApiModelProperty(value = "Nome da pessoa", name = "Nome", dataType = "String", required = true)
	private String nome;
	@ApiModelProperty(value = "Data de nascimento (00/00/0000)", name = "Data Nascimento", dataType = "Date", required = true)
	private Date nascimento;
	@ApiModelProperty(value = "Endereço da moradia", name = "Endereço", dataType = "String", required = true)
	private String endereco;
	@ApiModelProperty(value = "Cidade onde Reside", name = "Cidade", dataType = "String", required = true)
	private Integer cidade;
	@ApiModelProperty(value = "Telefone para Contato", name = "Telefone", dataType = "String")
	private String telefone;
	@ApiModelProperty(value = "E-mail para contato", name = "E-mail", dataType = "String", required = true)
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
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

	public PessoaModel(Long cpf, String nome, Date nascimento, String endereco, Integer cidade, String telefone,
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
