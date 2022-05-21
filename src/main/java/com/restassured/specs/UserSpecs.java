package com.restassured.specs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.config.*;
import com.restassured.data.factory.UserDataFactory;
import com.restassured.model.Users.User;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class UserSpecs {
    static UserDataFactory userDataFactory = new UserDataFactory();
    static Configuration configuration = ConfigurationManager.getConfiguration();

    private UserSpecs() {
    }

    public static RequestSpecification usersRequestSpec(int userID) {
        return new RequestSpecBuilder().
            addRequestSpecification(BaseStateSpecs.set()).
            setBasePath(configuration.basePath()+ configuration.usersPath()).
            //addPathParam("userID", userDataFactory.userID()).
            addQueryParam("id", userID).
            build();
    }
    
    public static RequestSpecification addusersRequestSpec(User user) {
    	//OAuth2Scheme auth = new OAuth2Scheme();
    	//auth.setAccessToken(configuration.token());
    	ObjectMapper objectMapper = new ObjectMapper();
    	String data = null ;
    	try {
			data = objectMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new RequestSpecBuilder().
            addRequestSpecification(BaseStateSpecs.set()).
            setBasePath(configuration.basePath()+ configuration.usersPath()).
            //setAuth(auth).
            setBody(data).
            build();
    }

    public static ResponseSpecification notFoundResponse() {
        return new ResponseSpecBuilder().
            expectStatusCode(HttpStatus.SC_NOT_FOUND).
            build();
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder().
            expectStatusCode(HttpStatus.SC_OK).
            build();
    }
    
    public static ResponseSpecification createdResponse() {
        return new ResponseSpecBuilder().
            expectStatusCode(HttpStatus.SC_CREATED).
            build();
    }

}
