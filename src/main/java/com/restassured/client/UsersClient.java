package com.restassured.client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.restassured.model.Users.User;
import com.restassured.specs.UserSpecs;

public class UsersClient {

    public Response queryUser(int userID){
        return
            given()
                .spec(UserSpecs.usersRequestSpec(userID))
            .when()
                // .get("?id={userID}")
                .get()
            .then()
                .spec(UserSpecs.successResponse())
                .extract()
                .response();

    }
    
    public Response addUser(User user) {
    	return
    			given()
    				.spec(UserSpecs.addusersRequestSpec(user))
    			.when()
    				.post()
    			.then()
    				.spec(UserSpecs.createdResponse())
    				.extract()
    				.response();
    				
    }
    
}
