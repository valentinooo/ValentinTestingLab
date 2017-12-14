package com.example.valentin.valentintestinglabs.manager;

import com.example.valentin.valentintestinglabs.model.Cake;

import java.util.ArrayList;

/**
 * Created by valentin on 12/12/2017.
 */

public class JobEvent {
    private ArrayList<Cake> arrayList = new ArrayList<>();

    public ArrayList<Cake> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Cake> arrayList) {
        this.arrayList = arrayList;
    }
}
