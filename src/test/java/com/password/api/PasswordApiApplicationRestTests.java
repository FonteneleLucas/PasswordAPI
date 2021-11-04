package com.password.api;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
class PasswordApiApplicationRestTests {
	
	
	
	@BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

	@Test
	void shouldReturnStatus200WhenSendAnyRequestToPostAPIPassword() {
		Response response = responsePost("");

        Assertions.assertEquals(200, response.statusCode());
 		
	}
	
	@Test
	void shouldReturnTRUEWhenSendValidPassword() {
		Response response = responsePost("09dFTp$7&lo");

        Assertions.assertEquals("true", response.getBody().asPrettyString());
 		
	}
	
	@Test
	void shouldReturnFALSEWhenSendInvalidPassword() {
		Response response = responsePost("09d&lo");

        Assertions.assertEquals("false", response.getBody().asPrettyString());
 		
	}

	private Response responsePost(String bodyInput) {
		Response response = given()
                .header("Content-type", ContentType.TEXT)
                .and()
                .body(bodyInput)
                .when()
                .post("/password")
                .then()
                .extract().response();
		return response;
	}
	


}
