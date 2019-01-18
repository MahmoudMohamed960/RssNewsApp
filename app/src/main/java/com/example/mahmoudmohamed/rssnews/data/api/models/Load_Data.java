package com.example.mahmoudmohamed.rssnews.data.api.models;

import android.app.Application;


import com.example.mahmoudmohamed.rssnews.data.api.interfaces.Api_Call;
import com.example.mahmoudmohamed.rssnews.data.repository.Repository_Class;
import com.example.mahmoudmohamed.rssnews.data.room.interfaces.Data_Operations_Interface;
import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.DataBase_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.Provider_Names_Model;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Load_Data {
    Api_Call call;
    Article_Info_Model model;
    Provider_Names_Model providerNamesModel;
    Repository_Class repo;
    List<Article> items;
    Article item;
    Application application;
    String providerName;
    Data_Operations_Interface dao;


    public Load_Data(Application application) {
        this.application=application;
        call=ApiUtilize.setBaseURL();
        repo=new Repository_Class(application);
        item=new Article();


    }





    public void loadRssWSJ()
    {
        System.out.println("you are here >>>>");
        call.loadRSSWSJ().enqueue(new Callback<Examples>() {
            @Override
            public void onResponse(Call<Examples>call, Response<Examples> response) {
                if(response.isSuccessful())
                {
                    System.out.println(response.body().getArticles().size());
                    items=response.body().getArticles();
                    for (int i=0;i<items.size();i++) {
                        item=items.get(i);
                        //System.out.println(item.getTitle());
                        String title = item.getTitle();
                        String image = item.getUrlToImage();
                        providerName=item.getSource().getName();
                         System.out.println(providerName);
                        model = new Article_Info_Model(providerName, title, image);
                        providerNamesModel=new Provider_Names_Model(providerName);
                        repo.insert(model);

                    }
                    repo.insertProviders(providerNamesModel);
                    repo.getProviderByname(providerName);

                }

                else
            {
                System.out.println("ERR 2 "+response.message());
            }
            }

            @Override
            public void onFailure(Call<Examples> call, Throwable t) {
                System.out.println("ERR 3 "+t);
            }
        });
       // System.out.println("?? "+sourceName);

    }

    public void loadRssCNN()
    {
        call.loadRSSCNN().enqueue(new Callback<Examples>() {
            @Override
            public void onResponse(Call<Examples>call, Response<Examples> response) {
                if(response.isSuccessful())
                {
                    System.out.println(response.body().getArticles().size());
                    items=response.body().getArticles();
                    for (int i=0;i<items.size();i++) {
                        item=items.get(i);
                        //System.out.println(item.getTitle());
                        String title = item.getTitle();
                        String image = item.getUrlToImage();
                        providerName=item.getSource().getName();
                        // System.out.println(providerName);
                        model = new Article_Info_Model(providerName, title, image);
                        providerNamesModel=new Provider_Names_Model(providerName);
                        repo.insert(model);
                    }
                    repo.insertProviders(providerNamesModel);
                    //System.out.println("ERR 1: Response correct >>>");
                    repo.getProviderByname(providerName);


                }

                else
                {
                    System.out.println("ERR 2 "+response.message());
                }
            }

            @Override
            public void onFailure(Call<Examples> call, Throwable t) {
                System.out.println("ERR 3 "+t);
            }
        });

    }

    public void loadRSSNBC() {
        call.loadRSSNBC().enqueue(new Callback<Examples>() {
            @Override
            public void onResponse(Call<Examples>call, Response<Examples> response) {
                if(response.isSuccessful())
                {
                    System.out.println(response.body().getArticles().size());
                    items=response.body().getArticles();
                    for (int i=0;i<items.size();i++) {
                        item=items.get(i);
                        //System.out.println(item.getTitle());
                        String title = item.getTitle();
                        String image = item.getUrlToImage();
                        providerName=item.getSource().getName();
                       // System.out.println(providerName);
                        model = new Article_Info_Model(providerName, title, image);
                        providerNamesModel=new Provider_Names_Model(providerName);
                        repo.insert(model);
                    }
                    repo.insertProviders(providerNamesModel);
                    //System.out.println("ERR 1: Response correct >>>");
                    repo.getProviderByname(providerName);
                    }

                else
                {
                    System.out.println("ERR 2 "+response.message());
                }
            }

            @Override
            public void onFailure(Call<Examples> call, Throwable t) {
                System.out.println("ERR 3 "+t);
            }
        });
    }


}
