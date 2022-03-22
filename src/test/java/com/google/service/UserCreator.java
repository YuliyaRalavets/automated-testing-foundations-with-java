package com.google.service;

import com.google.model.User;

public class UserCreator {
    public static final String USER_NUMBERS_OF_INSTANCE = "testdata.user.numberOfInstances";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_NUMBERS_OF_INSTANCE));
    }

    public static User withEmptyUserNumbersOfInstance(){
        return new User("");
    }
}
