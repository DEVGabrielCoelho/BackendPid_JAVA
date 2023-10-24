package br.com.api.atividade.pid.ResponseResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.atividade.pid.ResponseModel.GeneralResponseModel;

@CrossOrigin
@RestController
@RequestMapping(value = "base")
public class BaseResource {
	
	@GetMapping(value = "v001")
	public ResponseEntity<GeneralResponseModel> getColaborador(){
		
		GeneralResponseModel generalResponse = new GeneralResponseModel();
		
		generalResponse.setHttpStatus(200);
		generalResponse.setMessageStatus("REGISTRO EFETUADO COM SUCESSO");
		generalResponse.setDateRequest(new java.util.Date());
		generalResponse.setListSize(1);
		
		String name = "Projeto PID";
		
		generalResponse.setObject(name);
		
		return new ResponseEntity<GeneralResponseModel>(generalResponse, HttpStatus.OK);
		
	}

}
