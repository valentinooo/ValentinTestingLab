package com.example.valentin.valentintestinglabs.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valentin on 30/11/2017.
 */

public abstract class BaseRecyclerAdapter<T, V extends View> extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewWrapper<V>> {

    // ************************************************************************************************************************************************************************
    // * Variables
    // ************************************************************************************************************************************************************************

    @NonNull
    protected List<T> mItems = new ArrayList<>();



    // ************************************************************************************************************************************************************************
    // * Initialisation
    // ************************************************************************************************************************************************************************

    @NonNull
    @Override
    public final ViewWrapper<V> onCreateViewHolder(ViewGroup pParent, int pViewType) {
        return new ViewWrapper<>(onCreateItemView(pParent, pViewType));
    }

    /**
     * Abstract method to delegate the view creation to the concrete subclasses.
     *
     * @param pParent   The parent view
     * @param pViewType The view type
     * @return A view to show in the recycler.
     */
    protected abstract V onCreateItemView(ViewGroup pParent, int pViewType);

    // ************************************************************************************************************************************************************************
    // * List helper methods
    // ************************************************************************************************************************************************************************

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(@NonNull List<T> items) {
        notifyItemRangeRemoved(0, mItems.size());
        mItems.clear();
        mItems.addAll(items);
        notifyItemRangeInserted(0, mItems.size());
    }

    public void addItem(T item) {
        mItems.add(item);
        notifyItemInserted(mItems.size());
    }

    public void removeItem(int pos) {
        mItems.remove(pos);
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos, getItemCount() - pos);
    }

    @Nullable
    public T getItem(int position) {
        if (position > -1 && position < mItems.size()) {
            return mItems.get(position);
        }
        return null;
    }


    // ************************************************************************************************************************************************************************
    // * Base holder class for the view
    // ************************************************************************************************************************************************************************

    public static class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

        private V mView;

        public ViewWrapper(@NonNull V pItemView) {
            super(pItemView);
            mView = pItemView;
        }

        public V getView() {
            return mView;
        }
    }
}