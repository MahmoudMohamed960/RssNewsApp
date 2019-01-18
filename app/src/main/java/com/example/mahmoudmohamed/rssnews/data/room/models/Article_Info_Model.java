package com.example.mahmoudmohamed.rssnews.data.room.models;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Article_Info")
public class Article_Info_Model {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String providerName;
    private String articleTitle;
    private String articleImage;

    public Article_Info_Model(String providerName, String articleTitle, String articleImage) {
        this.providerName = providerName;
        this.articleTitle = articleTitle;
        this.articleImage = articleImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleImage() {
        return articleImage;
    }


}
