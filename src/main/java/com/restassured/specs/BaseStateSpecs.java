package com.restassured.specs;

import com.restassured.config.Configuration;
import com.restassured.config.ConfigurationManager;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HTTPBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseStateSpecs {

    private BaseStateSpecs() {
    }

    public static RequestSpecification set() {
        Configuration configuration = ConfigurationManager.getConfiguration();

        return new RequestSpecBuilder()
                .setBaseUri(configuration.baseUri())
                .setBasePath(configuration.basePath())
                .setPort(configuration.port())
                .addHeader("Authorization", "Bearer "+configuration.token())
                .setContentType(ContentType.JSON)
                .build();
    }
}
