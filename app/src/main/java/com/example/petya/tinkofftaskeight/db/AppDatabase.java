package com.example.petya.tinkofftaskeight.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.petya.tinkofftaskeight.db.node.Node;
import com.example.petya.tinkofftaskeight.db.node.NodeDao;
import com.example.petya.tinkofftaskeight.db.noderelation.NodeRelation;
import com.example.petya.tinkofftaskeight.db.noderelation.NodeRelationDao;

@Database(entities = {Node.class, NodeRelation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NodeDao NodeDao();
    public abstract NodeRelationDao NodeRelationDao();

    private static AppDatabase INSTANCE;

    private static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "nodes.db")
                        .allowMainThreadQueries()
                        .build();
            }
            return INSTANCE;
        }
    }
}
