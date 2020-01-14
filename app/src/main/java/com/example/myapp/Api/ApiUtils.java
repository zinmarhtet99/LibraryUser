package com.example.myapp.Api;

public class ApiUtils {

    public static final String BASE_URL="https://culibrary1.000webhostapp.com/api/";

    public static Apiinterface getApi(){
        return ApiClient.getRetrofit(BASE_URL).create(Apiinterface.class);
    }
}
