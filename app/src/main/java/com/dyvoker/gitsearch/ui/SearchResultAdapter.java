package com.dyvoker.gitsearch.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyvoker.gitsearch.R;
import com.dyvoker.gitsearch.core.GitRepository;
import com.dyvoker.gitsearch.core.GitRepositoryPage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchResultAdapter  extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder>  {
    private ArrayList<GitRepositoryPage> dataSet = new ArrayList<>();
    private OnClickListener onClickListener;

    public void setGitRepositoryPages(ArrayList<GitRepositoryPage> newPages) {
        if (newPages == null)
            throw new NullPointerException();
        dataSet = newPages;
        notifyDataSetChanged();
    }

    public void addGitRepositoryPage(GitRepositoryPage newPage) {
        if (newPage == null)
            throw new NullPointerException();
        dataSet.add(newPage);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_search_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GitRepository info = getRepository(position);
        Picasso.with(holder.itemView.getContext())
                .load(info.owner.avatar_url)
                .into(holder.userPicView);
        holder.repoNameView.setText(info.full_name);
        holder.repoDescriptionView.setText(info.description);
    }

    public GitRepository getRepository(int position) {
        int length = 0;
        for (GitRepositoryPage x : dataSet){
            if (position < length + x.items.length){
                return x.items[position - length];
            }
            length += x.items.length;
        }
        throw new IndexOutOfBoundsException();
    }

    public GitRepositoryPage getRepositoryPage(int position)
    {
        int length = 0;
        for (GitRepositoryPage x : dataSet){
            if (position < length + x.items.length){
                return x;
            }
            length += x.items.length;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int getItemCount() {
        int length = 0;
        if (dataSet.size() > 0) {
            for (GitRepositoryPage x : dataSet){
                if (x.items != null) {
                    length += x.items.length;
                }
            }
        }
        return length;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(ViewHolder viewHolder);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userPicView;
        TextView repoNameView;
        TextView repoDescriptionView;

        ViewHolder(View view) {
            super(view);
            userPicView = (ImageView) view.findViewById(R.id.userPicView);
            repoNameView = (TextView) view.findViewById(R.id.repoNameView);
            repoDescriptionView = (TextView) view.findViewById(R.id.repoDescriptionView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (SearchResultAdapter.this.onClickListener != null) {
                        SearchResultAdapter.this.onClickListener.onClick(ViewHolder.this);
                    }
                }
            });
        }
    }
}
