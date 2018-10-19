package com.stiggley.tests.stiggleyUserTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonObject;
import com.stiggley.Application;
import com.stiggley.models.StiggleyUser;
import com.stiggley.tests.TestDriver;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestDriver.class, properties="/stiggley-user/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes=Application.class)
public class StiggleyUserTest extends TestDriver {

	static String url = "http://localhost:9998";

	@Test
	public void canGetAllUsers() {
		RestAssured.get(url).prettyPrint();
	}

	@Test
	public void canAddUser() {
		StiggleyUser newUser = new StiggleyUser(0, "cd@gmail.com", "Christian", "DeFaria");

		JsonObject json = new JsonObject();
		json.addProperty("user", newUser.toString());

		int status = RestAssured.given().contentType("application/json").body(newUser).post(url).getStatusCode();

		assertEquals(201, status);
	}

	@Test
	public void canGetUserByEmail() {
		StiggleyUser newUser = new StiggleyUser(0, "dillonq@revature.com", "Dillon", "Qsee");

		JsonObject json = new JsonObject();
		json.addProperty("user", newUser.toString());

		int status = RestAssured.given().contentType("application/json").body(newUser).post(url + "/login")
				.getStatusCode();

		assertEquals(200, status);

	}

	@Test
	public void canNotGetUserByEmail() {
		StiggleyUser newUser = new StiggleyUser(1, "bs@gmail.com", "Brandon", "Scoggins");

		JsonObject json = new JsonObject();
		json.addProperty("user", newUser.toString());

		int status = RestAssured.given().contentType("application/json").body(newUser).post(url + "/login")
				.getStatusCode();

		assertEquals(404, status);

	}

	@Test
	public void canGetUserById() {
		StiggleyUser testUser = new StiggleyUser(4, "dillonq@revature.com", "Dillon", "Qsee");
		StiggleyUser user = RestAssured.get(url + "/4").body().as(StiggleyUser.class);

		assertEquals(testUser, user);

	}

	@Test
	public void canUpdateUser() {
		StiggleyUser updatedUser = new StiggleyUser(4, "dillonq@revature.com", "Dillon", "Qsee");

		JsonObject json = new JsonObject();
		json.addProperty("user", updatedUser.toString());

		StiggleyUser user = RestAssured.given().contentType("application/json").body(updatedUser).put(url).as(StiggleyUser.class);

		assertEquals(updatedUser, user);
	}

}
