package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.valentin.valentintestinglabs.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by valentin on 30/11/2017.
 */
@EActivity(R.layout.activity_objectbox)
public class ObjectBoxActivity extends AppCompatActivity {
    @AfterViews
    public void start(){
        ObjectBoxFragment objectBoxFragment = ObjectBoxFragment_.builder().build();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, objectBoxFragment);
        ft.commit();
    }
}
