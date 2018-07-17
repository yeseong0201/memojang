package com.example.ys020.memojang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyModel {
    private String title;
    private  String content;

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}
