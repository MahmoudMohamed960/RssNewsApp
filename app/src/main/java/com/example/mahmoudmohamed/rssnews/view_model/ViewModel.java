package com.example.mahmoudmohamed.rssnews.view_model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.example.mahmoudmohamed.rssnews.data.api.models.Load_Data;
import com.example.mahmoudmohamed.rssnews.data.repository.Repository_Class;
import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.Provider_Names_Model;

import java.util.List;

public class ViewModel extends AndroidViewModel {
     Repository_Class repository_class;
     LiveData<List<Provider_Names_Model>> listLiveDataProviders;
    private List<List<Article_Info_Model>> lists;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository_class=new Repository_Class(application);
        repository_class.load_data(new Load_Data(application));
        listLiveDataProviders=repository_class.getListLiveDataProviders();
        lists=repository_class.getLists();


    }

    public List<List<Article_Info_Model>> getLists() {
        return lists;
    }
    //get providers name

    public LiveData<List<Provider_Names_Model>> getListLiveDataProviders() {
        return listLiveDataProviders;
    }

    //insert
    public void insert(Article_Info_Model articleInfoModel)
    {
        repository_class.insert(articleInfoModel);
    }
    //delete
    public void delete(Article_Info_Model articleInfoModel)
    {
        repository_class.delete(articleInfoModel);
    }
    //delete all
    public void  deleteAll()
    {
        repository_class.deleteAll();
    }
    //get provider data


}
