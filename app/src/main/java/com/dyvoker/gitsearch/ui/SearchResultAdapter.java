package com.dyvoker.gitsearch.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyvoker.gitsearch.R;
import com.dyvoker.gitsearch.core.GitRepositoryInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchResultAdapter  extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>  {
    private ArrayList<GitRepositoryInfo> dataset;

    public SearchResultAdapter(ArrayList<GitRepositoryInfo> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_search_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GitRepositoryInfo info = dataset.get(position);
        Picasso.with(holder.itemView.getContext())
                .load(info.userPic)
                .into(holder.userPicView);
        holder.repoNameView.setText(info.fullName);
        holder.repoDescriptionView.setText(info.repoDescription);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView userPicView;
        public TextView repoNameView;
        public TextView repoDescriptionView;

        public ViewHolder(View view) {
            super(view);
            userPicView = (ImageView) view.findViewById(R.id.userPicView);
            repoNameView = (TextView) view.findViewById(R.id.repoNameView);
            repoDescriptionView = (TextView) view.findViewById(R.id.repoDescriptionView);
        }
    }
}
