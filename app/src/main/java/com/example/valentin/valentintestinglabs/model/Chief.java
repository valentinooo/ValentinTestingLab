package com.example.valentin.valentintestinglabs.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by valentin on 30/11/2017.
 */
@Entity
public class Chief {
    @Id
    long id;

    String chiefName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChiefName() {
        return chiefName;
    }

    public void setChiefName(String chiefName) {
        this.chiefName = chiefName;
    }
}
