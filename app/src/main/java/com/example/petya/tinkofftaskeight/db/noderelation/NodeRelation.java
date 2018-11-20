package com.example.petya.tinkofftaskeight.db.noderelation;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.example.petya.tinkofftaskeight.db.node.Node;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "node_relation",
        foreignKeys = @ForeignKey(entity = Node.class,
                parentColumns = "id",
                childColumns = "parentId"))

public class NodeRelation {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "parentId")
    private int parentId;

    private int childId;


    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public int getChildId() {
        return childId;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }




}
