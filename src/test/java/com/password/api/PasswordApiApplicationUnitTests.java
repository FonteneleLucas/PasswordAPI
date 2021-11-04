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
class PasswordApiApplicationUnitTests {
	
	@Autowired
	private PasswordValidator passwordValidator;

	@Test
	void assumeThatContainsBlankSpace() {
		assertThat(passwordValidator.containsBlankSpace(" ")).isTrue();
		assertThat(passwordValidator.containsBlankSpace("a b")).isTrue();
		assertThat(passwordValidator.containsBlankSpace("ab ")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsBlankSpace() {
		assertThat(passwordValidator.containsBlankSpace("")).isFalse();
		assertThat(passwordValidator.containsBlankSpace("abc")).isFalse();
	}
	
	@Test
	void assumeThatContainsDigit() {
		assertThat(passwordValidator.containsDigit("0")).isTrue();
		assertThat(passwordValidator.containsDigit("1")).isTrue();
		assertThat(passwordValidator.containsDigit("2")).isTrue();
		assertThat(passwordValidator.containsDigit("3")).isTrue();
		assertThat(passwordValidator.containsDigit("4")).isTrue();
		assertThat(passwordValidator.containsDigit("5")).isTrue();
		assertThat(passwordValidator.containsDigit("6")).isTrue();
		assertThat(passwordValidator.containsDigit("7")).isTrue();
		assertThat(passwordValidator.containsDigit("8")).isTrue();
		assertThat(passwordValidator.containsDigit("9")).isTrue();
		assertThat(passwordValidator.containsDigit("92b")).isTrue();
		assertThat(passwordValidator.containsDigit("ab3")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsDigit() {
		assertThat(passwordValidator.containsDigit("abc")).isFalse();
		assertThat(passwordValidator.containsDigit("-")).isFalse();
		assertThat(passwordValidator.containsDigit(" ")).isFalse();
	}
	
	@Test
	void assumeThatContainsLowerCase() {
		assertThat(passwordValidator.containsLowerCase("a")).isTrue();
		assertThat(passwordValidator.containsLowerCase("AbC")).isTrue();
		assertThat(passwordValidator.containsLowerCase("Abd")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsLowerCase() {
		assertThat(passwordValidator.containsLowerCase("A")).isFalse();
		assertThat(passwordValidator.containsLowerCase("ABC")).isFalse();
		assertThat(passwordValidator.containsLowerCase("-")).isFalse();
	}
	
	@Test
	void assumeThatContainsUpperCase() {
		assertThat(passwordValidator.containsUpperCase("A")).isTrue();
		assertThat(passwordValidator.containsUpperCase("aBc")).isTrue();
		assertThat(passwordValidator.containsUpperCase("abC")).isTrue();
		assertThat(passwordValidator.containsUpperCase("ABC")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsUpperCase() {
		assertThat(passwordValidator.containsUpperCase("a")).isFalse();
		assertThat(passwordValidator.containsUpperCase("abc")).isFalse();
		assertThat(passwordValidator.containsUpperCase("*")).isFalse();
		assertThat(passwordValidator.containsUpperCase("0")).isFalse();
	}
	
	@Test
	void assumeThatContainsMinimalSize() {
		assertThat(passwordValidator.containsMinimalSize("abcdefghi")).isTrue();
		assertThat(passwordValidator.containsMinimalSize("0123456789")).isTrue();
		assertThat(passwordValidator.containsMinimalSize("ABCDEFGHIJK")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsMinimalSize() {
		assertThat(passwordValidator.containsMinimalSize("abcdefgh")).isFalse();
		assertThat(passwordValidator.containsMinimalSize("01234567")).isFalse();
		assertThat(passwordValidator.containsMinimalSize("ABCDEFG")).isFalse();
		assertThat(passwordValidator.containsMinimalSize(" ")).isFalse();
	}
	
	@Test
	void assumeThatContainsRepeatedCharacters() {
		assertThat(passwordValidator.containsRepeatedCharacters("aa")).isTrue();
		assertThat(passwordValidator.containsRepeatedCharacters("aba")).isTrue();
		assertThat(passwordValidator.containsRepeatedCharacters("defgd")).isTrue();
		assertThat(passwordValidator.containsRepeatedCharacters("1o1")).isTrue();
		assertThat(passwordValidator.containsRepeatedCharacters("fe*f")).isTrue();
		assertThat(passwordValidator.containsRepeatedCharacters("$o$")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsRepeatedCharacters() {
		assertThat(passwordValidator.containsRepeatedCharacters("abc")).isFalse();
		assertThat(passwordValidator.containsRepeatedCharacters("012")).isFalse();
		assertThat(passwordValidator.containsRepeatedCharacters("*oikd")).isFalse();
	}
	
	@Test
	void assumeThatContainsSpecialCharacters() {//!|@|#|$|%|^|&|*|(|)|+|-
		assertThat(passwordValidator.containsSpecialCharacters("!")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("@")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("#")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("$")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("%")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("^")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("&")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("*")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("(")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters(")")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("+")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("-")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("asd$")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("*bc")).isTrue();
		assertThat(passwordValidator.containsSpecialCharacters("a&c")).isTrue();
	}
	
	@Test
	void assumeThatNotContainsSpecialCharacters() {//!|@|#|$|%|^|&|*|(|)|+|-
		assertThat(passwordValidator.containsSpecialCharacters(" ")).isFalse();
		assertThat(passwordValidator.containsSpecialCharacters("qwe")).isFalse();
		assertThat(passwordValidator.containsSpecialCharacters("123")).isFalse();
	}
	
	@Test
	void assumeThatPasswordIsValid() {
		assertThat(passwordValidator.definePasswordIsValid("AbTp9!fok")).isTrue();
		assertThat(passwordValidator.definePasswordIsValid("cDTp47&loK")).isTrue();
		assertThat(passwordValidator.definePasswordIsValid("09dFTp$7&lo")).isTrue();
		assertThat(passwordValidator.definePasswordIsValid("lF09%edkh")).isTrue();
	}
	
	@Test
	void assumeThatPasswordIsNotValid() {
		assertThat(passwordValidator.definePasswordIsValid("")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("aa")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("ab")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("AAAbbbCc")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("AbTp9!foo")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("AbTp9!foA")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("AbTp9 fok")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("Ab*pTp9!fok")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("AbTp9!")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("abc")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("09dFdp$7&lo")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("0123&9&asd")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("AbTp9!f ok")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("cDTpkK47&loK")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("09dF&Tp$7&lo")).isFalse();
		assertThat(passwordValidator.definePasswordIsValid("lF09%e dkh")).isFalse();
	}
	

}
