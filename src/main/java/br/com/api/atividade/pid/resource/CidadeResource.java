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

import br.com.api.atividade.pid.dao.TbCidadeDao;
import br.com.api.atividade.pid.entity.TbCidade;
import br.com.api.atividade.pid.model.CidadeModel;
import br.com.api.atividade.pid.response.model.GeneralResponseModel;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "apiPid/cidadeAPI/")
@Api(tags = "Cidade", description = "APIs Projeto PID")
public class CidadeResource {

	@PostMapping(value = "cidade/v001")
	@ApiResponse(description = "API de cadastro de cidade")
	public ResponseEntity<GeneralResponseModel> postCidade(@RequestBody List<CidadeModel> cidadeModels) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCidadeDao cidadeDao = new TbCidadeDao();
		TbCidade cidade = null;

		for (CidadeModel cidadeModel : cidadeModels) {
			cidade = cidadeDao.findByCidade(cidadeModel.getCidade());

			if (cidade == null) {
				cidade = new TbCidade();
				cidade.setCidade(cidadeModel.getCidade());
				cidadeDao.save(cidade);

				cidadeModel.setCodigo(cidade.getCodigo());

			} else {

				cidadeModel.setCodigo(cidade.getCodigo());
				cidadeModel.setCidade(cidade.getCidade());

				generalResponseModel.setHttpStatus(400);
				generalResponseModel.setMessageStatus("Já existe um registro para essa Cidade.");
				generalResponseModel.setDateRequest(new java.util.Date());
				generalResponseModel.setListSize(1);
				generalResponseModel.setObject(1);
				return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
			}

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(cidadeModels.size());

		generalResponseModel.setObject(cidadeModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@PutMapping(value = "cidade/v001")
	@ApiResponse(description = "API de atualização de cidade")
	public ResponseEntity<GeneralResponseModel> putCidade(@RequestBody List<CidadeModel> cidadeModels) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCidadeDao cidadeDao = new TbCidadeDao();
		TbCidade cidade = null;

		for (CidadeModel cidadeModel : cidadeModels) {
			cidade = cidadeDao.findId(cidadeModel.getCodigo());

			if (cidade != null) {

				cidade.setCidade(cidadeModel.getCidade());
				cidadeDao.update(cidade);
			} else {
				generalResponseModel.setHttpStatus(400);
				generalResponseModel.setMessageStatus("Não encontrado.");
				generalResponseModel.setDateRequest(new java.util.Date());
				generalResponseModel.setListSize(1);
				generalResponseModel.setObject(1);
				return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
			}

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(cidadeModels.size());

		generalResponseModel.setObject(cidadeModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@DeleteMapping(value = "cidade/v001/{id}")
	@ApiResponse(description = "API para deletar cidade")
	public ResponseEntity<GeneralResponseModel> deleteCidade(@PathVariable Integer id) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCidadeDao cidadeDao = new TbCidadeDao();
		TbCidade cidade = null;

		cidade = cidadeDao.findId(id);

		if (cidade != null) {
			cidadeDao.deleteById(cidade.getCodigo());
		} else {
			generalResponseModel.setHttpStatus(400);
			generalResponseModel.setMessageStatus("Não encontrado.");
			generalResponseModel.setDateRequest(new java.util.Date());
//			generalResponseModel.setListSize(cidade.);
			generalResponseModel.setObject(cidade);
			return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@GetMapping(value = "cidade/v001")
	@ApiResponse(description = "API para buscar de cidade")
	public ResponseEntity<GeneralResponseModel> getCidade() {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCidadeDao cidadeDao = new TbCidadeDao();
		List<TbCidade> cidade = cidadeDao.getList();
		List<CidadeModel> cidadeModels = new ArrayList<CidadeModel>();

		for (TbCidade cidades : cidade) {
			CidadeModel cidadeModel = new CidadeModel();

			cidadeModel.setCodigo(cidades.getCodigo());
			cidadeModel.setCidade(cidades.getCidade());
			cidadeModels.add(cidadeModel);

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(cidadeModels.size());

		generalResponseModel.setObject(cidadeModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}
}
