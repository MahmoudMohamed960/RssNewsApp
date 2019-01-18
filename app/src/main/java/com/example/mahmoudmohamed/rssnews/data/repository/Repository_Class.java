package com.example.mahmoudmohamed.rssnews.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import android.os.AsyncTask;

import com.example.mahmoudmohamed.rssnews.adapter.Parent_Recycle_Adapter;
import com.example.mahmoudmohamed.rssnews.data.api.models.Load_Data;
import com.example.mahmoudmohamed.rssnews.data.room.interfaces.Data_Operations_Interface;
import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.DataBase_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.Provider_Names_Model;

import java.util.ArrayList;
import java.util.List;

public class Repository_Class {
    private Data_Operations_Interface dao;
    private LiveData<List<Provider_Names_Model>> listLiveDataProviders;
    private Load_Data loadData;
    private List<List<Article_Info_Model>> lists;
    private List<Article_Info_Model>list;
    private Application application;
    public Repository_Class(Application application) {
        this.application=application;
        DataBase_Model dbModel = DataBase_Model.getInstance(application);
        dao = dbModel.dao();
        listLiveDataProviders=dao.selectAllProviders();
        list=new ArrayList<>();
        lists=new ArrayList<>();
    }

    //load data from websevice
    public void load_data(Load_Data load_data) {
        this.loadData = load_data;
        //delete all data before load newer
        deleteAll();
        deleteAllProvidersNames();
        System.out.println("ALL old Data deleted ");
        //load newer data
        //  System.out.println("load data ");
        loadData.loadRssWSJ();
        loadData.loadRssCNN();
        loadData.loadRSSNBC();
    }

    public List<List<Article_Info_Model>> getLists() {
        return lists;
    }

    public void setLists(List<List<Article_Info_Model>> lists) {
        this.lists = lists;
    }

//get providers name


    public LiveData<List<Provider_Names_Model>> getListLiveDataProviders() {
        return listLiveDataProviders;
    }

    //insert
    public void insert(Article_Info_Model articleInfoModel) {
        System.out.println("value 1" + articleInfoModel.getProviderName());
        new InsertRssAsyncTask(dao).execute(articleInfoModel);
    }

    private class InsertRssAsyncTask extends AsyncTask<Article_Info_Model, Void, Void> {
        Data_Operations_Interface dao;

        public InsertRssAsyncTask(Data_Operations_Interface dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Article_Info_Model... article_info_models) {
            System.out.println("value =" + article_info_models[0]);
            dao.inseret(article_info_models[0]);
            return null;
        }
    }

    //delete
    public void delete(Article_Info_Model articleInfoModel) {
        new DeleteProviderAsyncTask(dao).execute(articleInfoModel);
    }

    private class DeleteProviderAsyncTask extends AsyncTask<Article_Info_Model, String, Void> {
        Data_Operations_Interface dao;

        public DeleteProviderAsyncTask(Data_Operations_Interface dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Article_Info_Model... article_info_models) {
            dao.delete(article_info_models[0]);
            return null;
        }
    }

    //delete all
    public void deleteAll() {
        new DeleteAllProvidorsAsyncTask(dao).execute();
    }

    private class DeleteAllProvidorsAsyncTask extends AsyncTask<Void, Void, Void> {
        Data_Operations_Interface dao;

        public DeleteAllProvidorsAsyncTask(Data_Operations_Interface dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }

    //insert providers name
    //insert
    public void insertProviders(Provider_Names_Model providerNamesModel) {
        new InsertProviderNameRssAsyncTask(dao).execute(providerNamesModel);
    }

    private class InsertProviderNameRssAsyncTask extends AsyncTask<Provider_Names_Model, Void, Void> {
        Data_Operations_Interface dao;

        public InsertProviderNameRssAsyncTask( Data_Operations_Interface dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Provider_Names_Model... providerNamesModels) {
            //System.out.println("value =" + article_info_models[0]);
            dao.inseret(providerNamesModels[0]);
            return null;
        }
    }
    //delete all providers
    public void deleteAllProvidersNames() {
        new DeleteAllProvidorsNamesAsyncTask(dao).execute();
    }

    private class DeleteAllProvidorsNamesAsyncTask extends AsyncTask<Void, Void, Void> {
        Data_Operations_Interface dao;

        public DeleteAllProvidorsNamesAsyncTask( Data_Operations_Interface dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllProviders();
            return null;
        }
    }
    //get data by Provider
    //delete all providers
    public void getProviderByname(String providername) {
        new GetProviderByname(dao).execute(providername);
    }

    private class GetProviderByname extends AsyncTask<String, Void, Void> {
        Data_Operations_Interface dao;

        public GetProviderByname( Data_Operations_Interface dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(String... strings) {
            list=dao.selectBYProviderName(strings[0]);
            lists.add(list);
            System.out.println("gppppppppp"+list.size()+" jsjhsjh +"+lists.size());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Parent_Recycle_Adapter adapter=new Parent_Recycle_Adapter(application);
            System.out.println("herereerere "+lists.size());
            //adapter.setdata(lists);
        }
    }



}
