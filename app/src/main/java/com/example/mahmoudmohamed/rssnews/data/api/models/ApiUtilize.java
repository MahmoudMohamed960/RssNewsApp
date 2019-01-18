package com.example.mahmoudmohamed.rssnews.data.api.models;

import com.example.mahmoudmohamed.rssnews.data.api.interfaces.Api_Call;

public class ApiUtilize {
    public static final String BASE_URL="https://newsapi.org/v2/";

    public static Api_Call setBaseURL ()
    {
      return Retrofit_Client.getRetrofiClient(BASE_URL).create(Api_Call.class);
    }
}
