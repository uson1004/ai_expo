package com.example.ai_expo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ai_expo.Dtos.Post;
import com.example.ai_expo.todoMainActivity.ItemClickListener;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.BoardViewHolder> {


    private List<Post> posts;

    public DiaryAdapter(List<Post> posts) {
        this.posts = posts;
    }


    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new BoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        Log.e("position", String.valueOf(position));
        Log.e("test",posts.get(position).getTitle());

        holder.textViewTitle.setText(posts.get(position).getTitle());
        holder.textViewContent.setText(posts.get(position).getContent());
        holder.textViewDate.setText(posts.get(position).getDate().split("T")[0]);
        holder.textId.setText(String.valueOf(posts.get(position).getId()));

        holder.itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Long diaryId = (long) posts.get(position).getId();
                Intent intent = new Intent(view.getContext(), diary_3_mypage.class);
                intent.putExtra("id",diaryId);
                view.getContext().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        };
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class BoardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewTitle;
        public TextView textViewDate;
        public TextView textViewContent;

        public TextView textId;

        ItemClickListener itemClickListener;
        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textViewDate =(TextView) itemView.findViewById(R.id.textDate);
            textViewContent =(TextView) itemView.findViewById(R.id.textContent);
            textId =(TextView) itemView.findViewById(R.id.textId);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v,getLayoutPosition());
        }
    }
}

