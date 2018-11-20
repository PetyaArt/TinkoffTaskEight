package com.example.petya.tinkofftaskeight.db.node;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NodeDao {

    @Query("SELECT * FROM node")
    LiveData<List<Node>> getAll();

    @Query("SELECT * FROM node")
    List<Node> getAllNode();

    @Query("SELECT * FROM node WHERE id = :id")
    Node getById(int id);

    @Query("DELETE FROM node WHERE id = :id")
    void deleteById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Node node);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Node> nodes);

    @Insert
    void insert(Node node);

    @Update
    void update(Node node);

    @Delete
    void delete(Node node);
}
