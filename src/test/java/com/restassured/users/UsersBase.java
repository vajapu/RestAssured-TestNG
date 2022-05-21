package com.restassured.users;

import com.restassured.BaseAPI;
import com.restassured.data.factory.UserDataFactory;

import org.testng.annotations.BeforeTest;

public abstract class UsersBase extends BaseAPI {

    protected static UserDataFactory userDataFactory;

    @BeforeTest
    static void setup() {
        userDataFactory = new UserDataFactory();
    }
}
