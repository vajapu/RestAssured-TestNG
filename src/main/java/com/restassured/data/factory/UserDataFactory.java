package com.restassured.data.factory;

import com.github.javafaker.Faker;

public class UserDataFactory {

    private final Faker faker;

    public UserDataFactory() {
        faker = new Faker();
    }

    public int userID() {
        return faker.number().randomDigitNotZero();
    }
    
    public String getRandomMail() {
		return faker.internet().emailAddress();
	}

}
