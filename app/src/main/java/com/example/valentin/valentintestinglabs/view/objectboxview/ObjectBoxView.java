package com.example.valentin.valentintestinglabs.view.objectboxview;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.valentin.valentintestinglabs.R;
import com.example.valentin.valentintestinglabs.model.Cake;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by valentin on 30/11/2017.
 */

@EViewGroup(R.layout.rv_item_cake_list)
public class ObjectBoxView extends LinearLayout {

    @ViewById(R.id.cake_name)
    TextView mCakeName;

    @ViewById(R.id.chief_name)
            TextView mChefName;

    Context mContext;

    public ObjectBoxView(Context context) {
        super(context);
        mContext = context;
    }

    public void bind(Cake pCake, int pPosition){
        mCakeName.setText(pCake.getCakeName());
        mChefName.setText(pCake.getChiefName().getTarget().getChiefName());
       /* mOffer = pOffer;
        mPosition = pPosition;

        searchedOfferImage.setImageResource(R.drawable.dummy_offer_image);
        searchedOfferDiscount.setText(String.valueOf(mOffer.getDiscountPercentage()));
        searchedOfferType.setText(R.string.off);
        searchedOfferTitle.setText(mOffer.getName());
        searchedOfferLikesCount.setText(String.valueOf(mOffer.getTotalLikes()));*/
    }
}
