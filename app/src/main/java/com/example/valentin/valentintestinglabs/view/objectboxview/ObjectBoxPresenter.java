package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.support.annotation.NonNull;

import com.example.valentin.valentintestinglabs.manager.JobEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by valentin on 30/11/2017.
 */

public class ObjectBoxPresenter implements ObjectBoxContract.Presenter {

    ObjectBoxContract.View mView;

    public ObjectBoxPresenter(@NonNull ObjectBoxContract.View objectBoxView){
        this.mView = objectBoxView;
        mView.setPresenter(this);
    }


    @Override
    public void onStart() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(JobEvent event) {
        mView.onDataInserted(event.getArrayList());
    }
}
