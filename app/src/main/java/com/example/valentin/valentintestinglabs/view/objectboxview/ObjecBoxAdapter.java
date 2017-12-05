package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.view.ViewGroup;

import com.example.valentin.valentintestinglabs.adapter.BaseRecyclerAdapter;
import com.example.valentin.valentintestinglabs.model.Cake;

import org.androidannotations.annotations.EBean;

/**
 * Created by valentin on 30/11/2017.
 */
@EBean
public class ObjecBoxAdapter extends BaseRecyclerAdapter<Cake, ObjectBoxView> {
    @Override
    protected ObjectBoxView onCreateItemView(ViewGroup pParent, int pViewType) {
        return ObjectBoxView_.build(pParent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ObjectBoxView> holder, int position) {
        holder.getView().bind(mItems.get(position),position);
    }
}
