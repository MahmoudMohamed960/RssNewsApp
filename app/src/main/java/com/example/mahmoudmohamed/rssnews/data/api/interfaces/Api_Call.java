package com.example.mahmoudmohamed.rssnews.data.api.interfaces;

import com.example.mahmoudmohamed.rssnews.data.api.models.Examples;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Call {

    //wall street journal Link
    @GET("everything?domains=wsj.com&apiKey=2c2c2d2c1cf14e618f24eae9d82e2c61")
    Call<Examples> loadRSSWSJ();
    //Cnn link
    @GET("everything?sources=cnn&apiKey=2c2c2d2c1cf14e618f24eae9d82e2c61")
    Call<Examples> loadRSSCNN();
    //NBC News link
    @GET("everything?sources=nbc-news&apiKey=2c2c2d2c1cf14e618f24eae9d82e2c61")
    Call<Examples> loadRSSNBC();

}
