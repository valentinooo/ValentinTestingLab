package com.example.valentin.valentintestinglabs.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by valentin on 30/11/2017.
 */
@Entity
public class Cake {
    @Id
    long id;

    String cakeName;

    ToOne<Chief> chiefName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public ToOne<Chief> getChiefName() {
        return chiefName;
    }
}
