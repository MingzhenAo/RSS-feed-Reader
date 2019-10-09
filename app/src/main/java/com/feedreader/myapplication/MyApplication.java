package com.feedreader.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;


import java.io.Serializable;
import java.util.ArrayList;

public class MyApplication extends Application implements Serializable {

    private static final ArrayList<Button> BUTTONLIST = new ArrayList<>();
    private static final ArrayList<String> COLLECTIONLIST = new ArrayList<>();
    private static final ArrayList<MyContent> MDATAS = new ArrayList<>();
    private static final MyContent CONTENT = new MyContent("");


    private ArrayList<String> collectionList;
    private ArrayList<MyContent> mDatas;
    private MyContent content;
    private ArrayList<Button> buttonList;


    @Override
    public void onCreate() {
        super.onCreate();

        setButtonList(BUTTONLIST);
        setCollectionList(COLLECTIONLIST);
        setmDatas(MDATAS);
        setContent(CONTENT);


    }


    public void setButtonList(ArrayList<Button> buttonList) {
        this.buttonList = buttonList;
    }

    public ArrayList<Button> getButtonList() {

        return buttonList;
    }

    public void setContent(MyContent content) {
        this.content = content;
    }

    public MyContent getContent() {
        return content;
    }

    public ArrayList<MyContent> getmDatas() {
        return mDatas;
    }

    public void setmDatas(ArrayList<MyContent> mDatas) {
        this.mDatas = mDatas;
    }

    public ArrayList<String> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(ArrayList<String> collectionList) {
        this.collectionList = collectionList;
    }


}
