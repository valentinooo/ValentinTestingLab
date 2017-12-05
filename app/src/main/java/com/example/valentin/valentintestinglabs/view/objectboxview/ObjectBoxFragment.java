package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.valentin.valentintestinglabs.Application;
import com.example.valentin.valentintestinglabs.Application_;
import com.example.valentin.valentintestinglabs.R;
import com.example.valentin.valentintestinglabs.model.Cake;
import com.example.valentin.valentintestinglabs.model.Chief;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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

    @AfterViews
    public void afterLoad(){
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Click(R.id.saveNewData)
    void onclick(){
        Chief chief = new Chief();
        chief.setChiefName("Glados");
        Cake cake  = new Cake();
        cake.setCakeName("This cake is a lie");
        cake.getChiefName().setTarget(chief);
        Box<Cake> boxStore = Application_.getInstance().getBoxStore().boxFor(Cake.class);
        boxStore.put(cake);
    }

    @Click(R.id.loadObject)
    void onLoadObjectClick(){
        Box<Cake> boxStore = Application_.getInstance().getBoxStore().boxFor(Cake.class);
        mAdapter.setItems(boxStore.getAll());
    }

    @Override
    public void setPresenter(ObjectBoxContract.Presenter presenter) {
        mPresenter = presenter;
    }


}
