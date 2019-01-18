package com.example.mahmoudmohamed.rssnews.data.room.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Provider_Name")
public class Provider_Names_Model {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String providerName;

    public Provider_Names_Model(String providerName) {
        this.providerName = providerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getProviderName() {
        return providerName;
    }
}
