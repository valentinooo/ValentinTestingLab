package com.example.valentin.valentintestinglabs;

import android.util.Log;

import com.evernote.android.job.JobManager;
import com.example.valentin.valentintestinglabs.manager.JobCreator;
import com.example.valentin.valentintestinglabs.model.MyObjectBox;

import org.androidannotations.annotations.EApplication;

import io.objectbox.BoxStore;

/**
 * Created by valentin on 30/11/2017.
 */

@EApplication
public class Application extends android.app.Application {
    private BoxStore boxStore;

    private JobManager jobManager;

    public BoxStore getBoxStore() {
        return boxStore;
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(this).build();
        Log.e("MyApplication", "onCreate is called");
        JobManager.create(this).addJobCreator(new JobCreator());

    }

}
