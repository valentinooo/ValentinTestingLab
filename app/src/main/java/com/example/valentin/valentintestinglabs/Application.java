package com.example.valentin.valentintestinglabs;

import android.util.Log;

import com.example.valentin.valentintestinglabs.model.MyObjectBox;

import org.androidannotations.annotations.EApplication;

import io.objectbox.BoxStore;

/**
 * Created by valentin on 30/11/2017.
 */

@EApplication
public class Application extends android.app.Application {
    private BoxStore boxStore;

    public BoxStore getBoxStore() {
        return boxStore;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(this).build();
        Log.e("MyApplication", "onCreate is called");
    }

}
