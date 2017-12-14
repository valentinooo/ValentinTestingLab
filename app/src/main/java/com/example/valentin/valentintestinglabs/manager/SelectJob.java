package com.example.valentin.valentintestinglabs.manager;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.example.valentin.valentintestinglabs.Application_;
import com.example.valentin.valentintestinglabs.model.Cake;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import io.objectbox.Box;

/**
 * Created by valentin on 12/12/2017.
 */

public class SelectJob extends Job {
    public static final String TAG = "Select_Job";


    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        Box<Cake> boxStore = Application_.getInstance().getBoxStore().boxFor(Cake.class);
        ArrayList<Cake> arrayListy = (ArrayList<Cake>) boxStore.getAll();
        JobEvent jobEvent = new JobEvent();
        jobEvent.setArrayList(arrayListy);
        EventBus.getDefault().post(jobEvent);
        return Result.SUCCESS;
    }
}
