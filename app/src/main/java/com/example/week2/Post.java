package com.example.week2;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private int id;
    private String title;

    //Lets the GSON parser knows the text string is
    //  supposed to be the body value of the JSON
    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

}
