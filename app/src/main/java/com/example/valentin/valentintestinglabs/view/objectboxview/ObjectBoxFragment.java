package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.example.valentin.valentintestinglabs.Application;
import com.example.valentin.valentintestinglabs.Application_;
import com.example.valentin.valentintestinglabs.R;
import com.example.valentin.valentintestinglabs.manager.InsertJob;
import com.example.valentin.valentintestinglabs.manager.SelectJob;
import com.example.valentin.valentintestinglabs.model.Cake;
import com.example.valentin.valentintestinglabs.model.Chief;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import io.objectbox.Box;

/**
 * Created by valentin on 30/11/2017.
 */
@EFragment(R.layout.content_objectbox)
public class ObjectBoxFragment extends Fragment implements ObjectBoxContract.View {

    ObjectBoxContract.Presenter mPresenter;

    @Bean
    ObjecBoxAdapter mAdapter;

    @ViewById(R.id.cake_recycler_view)
    RecyclerView mRecyclerView;

    @ViewById(R.id.number_item)
    TextView mNumberItem;

    @AfterViews
    public void afterLoad(){
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Click(R.id.saveNewData)
    void onclick(){
        new JobRequest.Builder(InsertJob.TAG).startNow().build().schedule();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter = new ObjectBoxPresenter(this);
        EventBus.getDefault().register(mPresenter);

    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(mPresenter);
    }

    @Click(R.id.loadObject)
    void onLoadObjectClick(){
        new JobRequest.Builder(SelectJob.TAG).startNow().build().schedule();
    }

    @Override
    public void setPresenter(ObjectBoxContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void onDataInserted(ArrayList<Cake> arrayListy) {
        mAdapter.setItems(arrayListy);
        mNumberItem.setText("Number of item " + arrayListy.size());
    }

}
