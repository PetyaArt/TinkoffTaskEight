package com.example.petya.tinkofftaskeight;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.petya.tinkofftaskeight.db.node.Node;
import com.example.petya.tinkofftaskeight.db.noderelation.NodeRelation;

import java.util.List;

public class NodeAdapter extends RecyclerView.Adapter<NodeAdapter.ViewHolder> {

    private List<Node> mNodeList;
    private List<NodeRelation> mNodeRelationList;
    private NodeViewModel mNodeViewModel;

    public NodeAdapter(NodeViewModel nodeViewModel) {
        mNodeList = nodeViewModel.getAllNode();
        mNodeRelationList = nodeViewModel.getAllNodeRelation();
        mNodeViewModel = nodeViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_node, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Node node = mNodeList.get(i);
        viewHolder.id.setText(String.valueOf(node.getId()));
        viewHolder.value.setText(String.valueOf(node.getValue()));

        for (NodeRelation n : mNodeRelationList) {
            if (node.getId() == n.getParentId()) {
                for (NodeRelation n2 : mNodeRelationList) {
                    if (node.getId() == n2.getChildId()) {
                        viewHolder.linearLayout.setBackgroundColor(Color.RED);
                        return;
                    }
                }
                viewHolder.linearLayout.setBackgroundColor(Color.YELLOW);
                return;
            }
        }

        for (NodeRelation n : mNodeRelationList) {
            if (node.getId() == n.getChildId()) {
                viewHolder.linearLayout.setBackgroundColor(Color.BLUE);
                return;
            }
        }

        viewHolder.linearLayout.setBackgroundColor(Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return mNodeList.size();
    }

    public void setData(List<Node> newNodeList) {
        this.mNodeList = newNodeList;
        notifyDataSetChanged();
    }

    public void setData2(List<NodeRelation> newNodeRelationList) {
        this.mNodeRelationList = newNodeRelationList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id, value;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_text_id);
            value = itemView.findViewById(R.id.item_text_value);
            linearLayout = itemView.findViewById(R.id.parent_layout);
        }

    }

}
