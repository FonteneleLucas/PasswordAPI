package com.password.api.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PasswordValidator {

	private String password;
	
	

	public PasswordValidator() {
		super();
	}

	public PasswordValidator(String password) {
		super();
		this.password = password;
	}
	
	public Boolean containsMinimalSize(String pasString) {
		if (pasString.length() >= 9)
			return true;

		return false;
	}

	public Boolean containsBlankSpace(String pasString) {
		if (pasString.contains(" "))
			return true;

		return false;
	}

	public Boolean containsDigit(String pasString) {
		return regexVerification(pasString, "[0-9]");
	}

	public Boolean containsLowerCase(String pasString) {
		return regexVerification(pasString, "[a-z]");
	}

	public Boolean containsUpperCase(String pasString) {
		return regexVerification(pasString, "[A-Z]");
	}

	public Boolean containsSpecialCharacters(String pasString) {
		return regexVerification(pasString, "[!|@|#|$|%|^|&|*|(|)|+|-]");
	}

	public Boolean containsRepeatedCharacters(String pasString) {
		return !regexVerification(pasString, "(?:(.)(?!.*\\1)){" + pasString.length() + "}");
	}

	public Boolean regexVerification(String pasString, String _pattern) {
		Pattern pattern = Pattern.compile(_pattern);
		Matcher matcher = pattern.matcher(pasString);
		return matcher.find();
	}
	
	public Boolean definePasswordIsValid(String pasString) {
		if(containsMinimalSize(pasString) && 
				!containsBlankSpace(pasString) &&
					containsDigit(pasString) &&
						containsLowerCase(pasString) && 
							containsUpperCase(pasString) &&
								containsSpecialCharacters(pasString) &&
									!containsRepeatedCharacters(pasString)) {
			
			return true;
		}else {
			
			return false;
		}
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String redirect() {
		return "<br><center><b><a href='http://localhost:8080/swagger-ui/'>Clique para acessar a documentação SWAGGER da API</a></b></center>";
	}
	
	
	public Boolean getIsValid() {
		
		return definePasswordIsValid(password);

	}

}
