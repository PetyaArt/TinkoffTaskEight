package com.example.petya.tinkofftaskeight.db.noderelation;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NodeRelationDao {

    @Query("SELECT * FROM node_relation")
    LiveData<List<NodeRelation>> getAll();

    @Query("SELECT * FROM node_relation")
    List<NodeRelation> getAllNodesRelation();

    @Query("SELECT * FROM node_relation WHERE id = :id")
    NodeRelation getById(int id);

    @Insert
    void insert(NodeRelation nodeRelation);

    @Update
    void update(NodeRelation nodeRelation);

    @Delete
    void delete(NodeRelation nodeRelation);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void nodeRelationDao(NodeRelation nodeRelation);
}
