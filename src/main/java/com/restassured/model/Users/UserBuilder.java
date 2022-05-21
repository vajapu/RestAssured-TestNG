package com.restassured.model.Users;

public class UserBuilder {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public UserBuilder id(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder status(String status) {
        this.status = status;
        return this;
    }

    public User build() {
        return new User(id, name, email, gender, status);
    }
    
}
