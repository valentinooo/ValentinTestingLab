package com.example.valentin.valentintestinglabs.manager;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.example.valentin.valentintestinglabs.Application_;
import com.example.valentin.valentintestinglabs.model.Cake;
import com.example.valentin.valentintestinglabs.model.Chief;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import io.objectbox.Box;

/**
 * Created by valentin on 12/12/2017.
 */

public class InsertJob extends Job {

    public static final String TAG = "Insert_Job";

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        ArrayList<Cake> arrayListy = new ArrayList<>();
        for(int i = 0; i<100;i++){
            Chief chief = new Chief();
            chief.setChiefName("Glados");
            Cake cake  = new Cake();
            cake.setCakeName("This cake is a lie");
            cake.getChiefName().setTarget(chief);
            arrayListy.add(cake);
        }

        Box<Cake> boxStore = Application_.getInstance().getBoxStore().boxFor(Cake.class);
        boxStore.put(arrayListy);
        return Result.SUCCESS;
    }
}
