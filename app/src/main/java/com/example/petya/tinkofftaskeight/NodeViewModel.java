package com.example.petya.tinkofftaskeight;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.petya.tinkofftaskeight.db.AppDatabase;
import com.example.petya.tinkofftaskeight.db.node.Node;
import com.example.petya.tinkofftaskeight.db.node.NodeDao;
import com.example.petya.tinkofftaskeight.db.noderelation.NodeRelation;
import com.example.petya.tinkofftaskeight.db.noderelation.NodeRelationDao;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NodeViewModel extends AndroidViewModel {

    private NodeDao mNodeDao;
    private NodeRelationDao mNodeRelationDao;
    private ExecutorService mExecutorService;

    public NodeViewModel(@NonNull Application app) {
        super(app);
        mNodeDao = AppDatabase.getInstance(app.getApplicationContext()).NodeDao();
        mNodeRelationDao = AppDatabase.getInstance(app.getApplicationContext()).NodeRelationDao();
        mExecutorService = Executors.newSingleThreadExecutor();
    }

    LiveData<List<Node>> getAll() {
        return mNodeDao.getAll();
    }

    List<Node> getAllNode() {
        return mNodeDao.getAllNode();
    }

    void saveNode(Node node) {
        mExecutorService.execute(() -> mNodeDao.save(node));
    }

    void deletePost(Node node) {
        mExecutorService.execute(() -> mNodeDao.delete(node));
    }

    void saveNodeRelation(NodeRelation nodeRelation) {
        mExecutorService.execute( () -> mNodeRelationDao.nodeRelationDao(nodeRelation));
    }

    LiveData<List<NodeRelation>> getAll2() {
        return mNodeRelationDao.getAll();
    }

    List<NodeRelation> getAllNodeRelation() {
        return mNodeRelationDao.getAllNodesRelation();
    }
}
