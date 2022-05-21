package com.restassured.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({"system:properties","classpath:com/restassured/resources/api.properties"})
public interface Configuration extends Config{

    @Key("api.logAll")
    boolean logAll();

    @Key("api.base.uri")
    String baseUri();

    @Key("api.base.path")
    String basePath();

    @Key("api.users.path")
    String usersPath();

    @Key("api.port")
    int port();
    
    @Key("api.token")
    String token();

}
