package com.example.petya.tinkofftaskeight;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.petya.tinkofftaskeight.db.node.Node;
import com.example.petya.tinkofftaskeight.db.noderelation.NodeRelation;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        ExampleDialog.ExampleDialogListener,
        DeleteDialog.DeleteDialogListener {

    private RecyclerView mRecyclerView;
    private NodeAdapter mNodeAdapter;

    NodeViewModel mNodeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNodeViewModel = ViewModelProviders.of(this).get(NodeViewModel.class);
        mNodeViewModel.getAll().observe(this, nodes -> mNodeAdapter.setData(nodes));
        mNodeViewModel.getAll2().observe(this, nodeRelations -> mNodeAdapter.setData2(nodeRelations));

        mNodeAdapter = new NodeAdapter(mNodeViewModel);
        mRecyclerView = findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mNodeAdapter);
    }

    public void onClick(View view) {
        Node node = new Node();
        node.setValue((int) (Math.random() * 1000));
        mNodeViewModel.saveNode(node);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                ExampleDialog exampleDialog = new ExampleDialog();
                exampleDialog.show(getSupportFragmentManager(), "lol");
                break;
            case R.id.item_delete:
                DeleteDialog deleteDialog = new DeleteDialog();
                deleteDialog.show(getSupportFragmentManager(), "sad");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void applyTexts(String parent, String child) {
        NodeRelation nodeRelation = new NodeRelation();
        nodeRelation.setParentId(Integer.parseInt(parent));
        nodeRelation.setChildId(Integer.parseInt(child));
        mNodeViewModel.saveNodeRelation(nodeRelation);
    }

    @Override
    public void delete(String id) {
        mNodeViewModel.deleteById(Integer.valueOf(id));
    }
}
