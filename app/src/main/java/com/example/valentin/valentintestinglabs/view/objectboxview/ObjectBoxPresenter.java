package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.support.annotation.NonNull;

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
}
