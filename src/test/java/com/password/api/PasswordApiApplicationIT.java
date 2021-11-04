package com.password.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.password.api.service.PasswordValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
class PasswordApiApplicationIT {
	
	@Autowired
	private PasswordValidator passwordValidator;

	@Test
	void verifyRegexReturn() {
		assertThat(passwordValidator.regexVerification("teste", "[a-z]")).isTrue();
		assertThat(passwordValidator.regexVerification("asd2asd", "[0-9]")).isTrue();
	}
	
	@Test
	void verifyRegexReturnFail() {
		assertThat(passwordValidator.regexVerification("123", "[a-z]")).isFalse();
		assertThat(passwordValidator.regexVerification("asd", "[0-9]")).isFalse();
	}

	@Test
	void verifyPasswordIsValidReturnTRUE() {
		assertThat(passwordValidator.definePasswordIsValid("AbTp9!fok")).isTrue();
	}
	
	@Test
	void verifyPasswordIsValidReturnFALSE() {
		assertThat(passwordValidator.definePasswordIsValid("AbT!!fok")).isFalse();
	}
}
