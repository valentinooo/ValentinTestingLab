package com.example.valentin.valentintestinglabs.view.objectboxview;

import com.example.valentin.valentintestinglabs.model.Cake;
import com.example.valentin.valentintestinglabs.view.BasePresenter;
import com.example.valentin.valentintestinglabs.view.BaseView;

import java.util.ArrayList;

/**
 * Created by valentin on 30/11/2017.
 */

public interface ObjectBoxContract {
    interface View extends BaseView<Presenter> {
        void onDataInserted(ArrayList<Cake> arrayListy);

    }

    interface Presenter extends BasePresenter{
        void onStart();
    }
}
