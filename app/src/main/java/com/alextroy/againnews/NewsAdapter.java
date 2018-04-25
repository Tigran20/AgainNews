package com.alextroy.againnews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsItem> listItem;
    private Context context;

    public NewsAdapter(Context context, List<NewsItem> list) {
        this.context = context;
        listItem = list;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem result = listItem.get(position);
        Picasso.get().load(result.getFields().getThumbnail()).into(holder.newsImageView);
        holder.titleTextView.setText(result.getWebTitle());
        holder.descriptionTextView.setText(result.getFields().getTrailText());
        holder.sectionNameTextView.setText(result.getSectionName());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void setData(List<NewsItem> list) {
        listItem.addAll(list);
        if (listItem.isEmpty()) {
            Toast.makeText(context, "No news", Toast.LENGTH_SHORT).show();
        }
        notifyDataSetChanged();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView newsImageView;
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView sectionNameTextView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.news_image);
            titleTextView = itemView.findViewById(R.id.news_title);
            descriptionTextView = itemView.findViewById(R.id.news_description);
            sectionNameTextView = itemView.findViewById(R.id.news_section_name);
        }
    }
}
