package com.restassured.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.client.UsersClient;
import com.restassured.model.Users.User;
import com.restassured.model.Users.UserBuilder;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UsersTest extends UsersBase {

	User user = null;
	UsersClient usersClient = new UsersClient();

	@Test(priority = 2, dependsOnMethods = { "addUsers" })
	public void getUsers() {
		Response res = usersClient.queryUser(user.getId());
		JsonPath jsonPathEvaluator = res.jsonPath();
		assertThat((String) jsonPathEvaluator.get("name[0]")).isEqualTo(user.getName());
	}

	@Test(priority = 1)
	public void addUsers() {
		user = new UserBuilder()
				.email(userDataFactory.getRandomMail())
				.name("test1")
				.id(12378)
				.gender("male")
				.status("active")
				.build();
		Response res = usersClient.addUser(user);
		user = res.getBody().as(User.class);
		JsonPath jsonPathEvaluator = res.jsonPath();
		assertThat((String) jsonPathEvaluator.get("name")).isEqualTo("test1");
	}

}
