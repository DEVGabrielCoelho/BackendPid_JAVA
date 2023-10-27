package br.com.api.atividade.pid.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.atividade.pid.dao.TbPessoaDao;
import br.com.api.atividade.pid.entity.TbPessoa;
import br.com.api.atividade.pid.model.PessoaModel;
import br.com.api.atividade.pid.response.model.GeneralResponseModel;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "apiPid/pessoaAPI/")
@Api(tags = "Pessoa", description = "APIs Projeto PID")
public class PessoaResource {

	@PostMapping(value = "pessoa/v001")
	@ApiResponse(description = "API de cadastro de pessoa")
	public ResponseEntity<GeneralResponseModel> postPessoa(@RequestBody List<PessoaModel> pessoaModels) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbPessoaDao pessoaDao = new TbPessoaDao();
		TbPessoa pessoa = null;

		for (PessoaModel pessoaModel : pessoaModels) {
			pessoa = pessoaDao.findByPessoa(pessoaModel.getCpf());

			if (pessoa == null) {
				pessoa = new TbPessoa();
				pessoa.setCpf(pessoaModel.getCpf());
				pessoa.setNome(pessoaModel.getNome());
				pessoa.setNascimento(pessoaModel.getNascimento());
				pessoa.setEndereco(pessoaModel.getEndereco());
				pessoa.setCidade(pessoaModel.getCidade());
				pessoa.setTelefone(pessoaModel.getTelefone());
				pessoa.setEmail(pessoaModel.getEmail());
				pessoaDao.save(pessoa);

			} else {

				generalResponseModel.setHttpStatus(400);
				generalResponseModel.setMessageStatus("Já existe um registro para essa Pessoa.");
				generalResponseModel.setDateRequest(new java.util.Date());
				generalResponseModel.setListSize(pessoaModels.size());
				generalResponseModel.setObject(pessoaModels);
				return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
			}

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(pessoaModels.size());

		generalResponseModel.setObject(pessoaModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@PutMapping(value = "pessoa/v001")
	@ApiResponse(description = "API de atualização de pessoa")
	public ResponseEntity<GeneralResponseModel> putPessoa(@RequestBody List<PessoaModel> pessoaModels) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbPessoaDao pessoaDao = new TbPessoaDao();
		TbPessoa pessoa = null;

		for (PessoaModel pessoaModel : pessoaModels) {
			pessoa = pessoaDao.findId(pessoaModel.getCpf());

			if (pessoa != null) {

				pessoa.setNome(pessoaModel.getNome());
				pessoa.setNascimento(pessoaModel.getNascimento());
				pessoa.setEndereco(pessoaModel.getEndereco());
				pessoa.setCidade(pessoaModel.getCidade());
				pessoa.setTelefone(pessoaModel.getTelefone());
				pessoa.setEmail(pessoaModel.getEmail());
				pessoaDao.update(pessoa);

			} else {
				generalResponseModel.setHttpStatus(400);
				generalResponseModel.setMessageStatus("Não encontrado.");
				generalResponseModel.setDateRequest(new java.util.Date());
				generalResponseModel.setListSize(pessoaModels.size());
				generalResponseModel.setObject(pessoaModels);
				return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
			}

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(pessoaModels.size());

		generalResponseModel.setObject(pessoaModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@DeleteMapping(value = "pessoa/v001/{cpf}")
	@ApiResponse(description = "API para deletar pessoa")
	public ResponseEntity<GeneralResponseModel> deletePessoa(@PathVariable Long cpf) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbPessoaDao pessoaDao = new TbPessoaDao();
		TbPessoa pessoa = null;

		pessoa = pessoaDao.findId(cpf);

		if (pessoa != null) {
			pessoaDao.deleteById(pessoa.getCpf());
		} else {
			generalResponseModel.setHttpStatus(400);
			generalResponseModel.setMessageStatus("Não encontrado.");
			generalResponseModel.setDateRequest(new java.util.Date());
//			generalResponseModel.setListSize(pessoa.);
			generalResponseModel.setObject(pessoa);
			return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@GetMapping(value = "pessoa/v001")
	@ApiResponse(description = "API para buscar de pessoa")
	public ResponseEntity<GeneralResponseModel> getPessoa() {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbPessoaDao pessoaDao = new TbPessoaDao();
		List<TbPessoa> pessoaList = pessoaDao.getList();
		List<PessoaModel> pessoaModels = new ArrayList<PessoaModel>();

		for (TbPessoa pessoas : pessoaList) {
			PessoaModel pessoaModel = new PessoaModel();

			pessoaModel.setCpf(pessoas.getCpf());
			pessoaModel.setNome(pessoas.getNome());
			pessoaModel.setNascimento(pessoas.getNascimento());
			pessoaModel.setEndereco(pessoas.getEndereco());
			pessoaModel.setCidade(pessoas.getCidade());
			pessoaModel.setTelefone(pessoas.getTelefone());
			pessoaModel.setEmail(pessoas.getEmail());
			pessoaModels.add(pessoaModel);

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(pessoaModels.size());

		generalResponseModel.setObject(pessoaModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

}
