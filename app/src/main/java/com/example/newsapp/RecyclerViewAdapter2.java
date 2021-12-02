package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.RecyclerViewHolder>
{
    private ArrayList<modelAPIClass> modelAPIClassArrayList;
    private Context mcontext;

    public RecyclerViewAdapter2(ArrayList<modelAPIClass> modelAPIClassArrayList, Context mcontext) {
        this.modelAPIClassArrayList = modelAPIClassArrayList;
        this.mcontext = mcontext;

    }


    @NonNull
    @Override
    public RecyclerViewAdapter2.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlenews, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        /*holder.cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("url", modelAPIClassArrayList.get(position).getUrl());
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                WebNews webNews = new WebNews();
                webNews.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, webNews).addToBackStack(null).commit();
             }
        });
        */

        holder.head.setText(modelAPIClassArrayList.get(position).getTitle());
        holder.des.setText(modelAPIClassArrayList.get(position).getDescription());
        holder.time.setText("Published at : " + modelAPIClassArrayList.get(position).getPublishedAt());
        holder.author.setText("Author : " + modelAPIClassArrayList.get(position).getAuthor());
        Glide.with(mcontext).load(modelAPIClassArrayList.get(position).getUrlToImage()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return modelAPIClassArrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView head,des,time,author;
        ConstraintLayout cardView;
        ImageView img;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.mainheading);
            des = itemView.findViewById(R.id.des);
            time = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.img);
            cardView = itemView.findViewById(R.id.card);
            author = itemView.findViewById(R.id.author);

        }
    }
}
