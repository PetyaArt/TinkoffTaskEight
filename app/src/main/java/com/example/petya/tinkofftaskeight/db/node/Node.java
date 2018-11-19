package com.example.petya.tinkofftaskeight.db.node;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "node")
public class Node {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int value;

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }
}
