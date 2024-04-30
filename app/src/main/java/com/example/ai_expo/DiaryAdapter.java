package com.example.ai_expo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ai_expo.Dtos.PostResponses.Post;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.BoardViewHolder> {

    private List<Post> posts;

    public DiaryAdapter(List<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_diary2,parent,false);
        return new BoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class BoardViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewDate;
        public TextView textViewContent;

        public TextView textId;

        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textTitle);
            textViewDate = itemView.findViewById(R.id.textDate);
            textViewContent = itemView.findViewById(R.id.textContent);
            textId = itemView.findViewById(R.id.textId);
        }

        void onBind(Post post){
            textViewTitle.setText(post.getTitle());
            textViewContent.setText(post.getContent());
            textViewDate.setText(post.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            textId.setText(post.getId());
        }
    }
}

