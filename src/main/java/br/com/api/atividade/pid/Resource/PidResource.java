package br.com.api.atividade.pid.Resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.atividade.pid.DAO.TbCategoriaProdutoDao;
import br.com.api.atividade.pid.Entity.TbCategoriaProduto;
import br.com.api.atividade.pid.Model.CatProdutoModel;
import br.com.api.atividade.pid.ResponseModel.GeneralResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "apiPid")
@Api(tags = "APIs Projeto PID")
public class PidResource {

	@PostMapping(value = "categoria-produto/v001")
	@ApiOperation("API de cadastro de categoria de produtos")
	public ResponseEntity<GeneralResponseModel> postCursoExtra(@RequestBody List<CatProdutoModel> catProdutoModels) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCategoriaProdutoDao categoriaProdutoDao = new TbCategoriaProdutoDao();
		TbCategoriaProduto categoriaProduto = null;

		for (CatProdutoModel catProdutoModel : catProdutoModels) {
			categoriaProduto = categoriaProdutoDao.findByCategoria(catProdutoModel.getCategoria());

			if (categoriaProduto == null) {
				categoriaProduto = new TbCategoriaProduto();
				categoriaProduto.setCategoria(catProdutoModel.getCategoria());
				categoriaProdutoDao.save(categoriaProduto);

				catProdutoModel.setId(categoriaProduto.getCodigo());

			} else {

				catProdutoModel.setId(categoriaProduto.getCodigo());
				catProdutoModel.setCategoria(categoriaProduto.getCategoria());

				generalResponseModel.setHttpStatus(400);
				generalResponseModel.setMessageStatus("Já existe um registro para essa categoria.");
				generalResponseModel.setDateRequest(new java.util.Date());
				generalResponseModel.setListSize(1);
				generalResponseModel.setObject(1);
				return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
			}

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(catProdutoModels.size());

		generalResponseModel.setObject(catProdutoModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@PutMapping(value = "categoria-produto/v001")
	@ApiOperation("API de cadastro de categoria de produtos")
	public ResponseEntity<GeneralResponseModel> putCursoExtra(@RequestBody List<CatProdutoModel> catProdutoModels) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCategoriaProdutoDao categoriaProdutoDao = new TbCategoriaProdutoDao();
		TbCategoriaProduto categoriaProduto = null;

		for (CatProdutoModel catProdutoModel : catProdutoModels) {
			categoriaProduto = categoriaProdutoDao.findId(catProdutoModel.getId());

			if (categoriaProduto != null) {

				categoriaProduto.setCategoria(catProdutoModel.getCategoria());
				categoriaProdutoDao.update(categoriaProduto);
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
		generalResponseModel.setListSize(catProdutoModels.size());

		generalResponseModel.setObject(catProdutoModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@DeleteMapping(value = "categoria-produto/v001/{id}")
	@ApiOperation("API de cadastro de categoria de produtos")
	public ResponseEntity<GeneralResponseModel> deleteCursoExtra(@PathVariable Integer id) {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCategoriaProdutoDao categoriaProdutoDao = new TbCategoriaProdutoDao();
		TbCategoriaProduto categoriaProduto = null;

		categoriaProduto = categoriaProdutoDao.findId(id);

		if (categoriaProduto != null) {
			categoriaProdutoDao.deleteById(categoriaProduto.getCodigo());
		} else {
			generalResponseModel.setHttpStatus(400);
			generalResponseModel.setMessageStatus("Não encontrado.");
			generalResponseModel.setDateRequest(new java.util.Date());
//			generalResponseModel.setListSize(categoriaProduto.);
			generalResponseModel.setObject(categoriaProduto);
			return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.BAD_REQUEST);
		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}

	@GetMapping(value = "categoria-produto/v001")
	@ApiOperation("API de cadastro de categoria de produtos")
	public ResponseEntity<GeneralResponseModel> getCursoExtra() {

		GeneralResponseModel generalResponseModel = new GeneralResponseModel();
		TbCategoriaProdutoDao categoriaProdutoDao = new TbCategoriaProdutoDao();
		List<TbCategoriaProduto> categoriaProduto = categoriaProdutoDao.getList();
		List<CatProdutoModel> catProdutoModels = new ArrayList<CatProdutoModel>();

		for (TbCategoriaProduto categoriaProdutos : categoriaProduto) {
			CatProdutoModel catProdutoModel = new CatProdutoModel();

			catProdutoModel.setId(categoriaProdutos.getCodigo());
			catProdutoModel.setCategoria(categoriaProdutos.getCategoria());
			catProdutoModels.add(catProdutoModel);

		}

		generalResponseModel.setHttpStatus(200);
		generalResponseModel.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponseModel.setDateRequest(new java.util.Date());
		generalResponseModel.setListSize(catProdutoModels.size());

		generalResponseModel.setObject(catProdutoModels);

		return new ResponseEntity<GeneralResponseModel>(generalResponseModel, HttpStatus.OK);

	}
}
