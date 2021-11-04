package com.password.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.password.api.service.PasswordValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Eventos")
@RestController
@RequestMapping("/")
public class PasswordResource {
	
	@Autowired
	PasswordValidator validator;

	@GetMapping
	public String basePath() {
		return validator.redirect();
	}
	
	@ApiOperation(value="Retorna link de acesso ao SWAGGER")
	@GetMapping("/password")
	public String passwordGetResource() {
		return validator.redirect();
	}
	
	@ApiOperation(value="Realiza a validação da Senha")
	@PostMapping("/password")
	public Boolean passwordPostResource(@RequestBody(required = false) String password) {
		
		if(password != null) {
			validator = new PasswordValidator(password);
			
			return validator.getIsValid();
		}
		
		
		return false;
	}
	
	
	
}
