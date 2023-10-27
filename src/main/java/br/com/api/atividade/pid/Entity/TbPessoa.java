package br.com.api.atividade.pid.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TbPessoa {

	@Id
	private Long cpf;
	private String nome;
	private LocalDate nascimento;
	private String endereco;
	private Integer cidade;
	private String telefone;
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

	public TbPessoa(Long cpf, String nome, LocalDate nascimento, String endereco, Integer cidade, String telefone,
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

	public TbPessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

}
