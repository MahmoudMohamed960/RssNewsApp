package com.example.mahmoudmohamed.rssnews.data.room.models;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

import com.example.mahmoudmohamed.rssnews.data.room.interfaces.Data_Operations_Interface;
@Database(entities = {Article_Info_Model.class,Provider_Names_Model.class},version = 2)
public abstract class DataBase_Model extends RoomDatabase {
    private static DataBase_Model model;

    public abstract Data_Operations_Interface dao();

    public static synchronized DataBase_Model getInstance(Context context) {
        if (model == null) {
            model = Room.databaseBuilder(context.getApplicationContext(), DataBase_Model.class, "RssDB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return model;
    }
}

