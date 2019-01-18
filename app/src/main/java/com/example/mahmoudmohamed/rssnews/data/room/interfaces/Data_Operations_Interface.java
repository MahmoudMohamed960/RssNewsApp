package com.example.mahmoudmohamed.rssnews.data.room.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mahmoudmohamed.rssnews.data.room.models.Article_Info_Model;
import com.example.mahmoudmohamed.rssnews.data.room.models.Provider_Names_Model;

import java.util.List;

@Dao
public interface Data_Operations_Interface {

    //all data
    @Insert
    void inseret(Article_Info_Model model);
    @Delete
    void delete (Article_Info_Model model);
    @Query("DELETE FROM Article_Info")
    void deleteAll ();
    @Query("SELECT * FROM Article_Info")
    LiveData<List<Article_Info_Model>>selectAll( );
    @Query("SELECT * FROM Article_Info  WHERE providerName LIKE :providerName")
    List<Article_Info_Model>selectBYProviderName(String providerName);
    //providers names
    @Insert
    void inseret(Provider_Names_Model model);
    @Query("SELECT * FROM Provider_Name")
    LiveData<List<Provider_Names_Model>> selectAllProviders( );
    @Query("DELETE FROM Provider_Name")
    void deleteAllProviders ();

}
