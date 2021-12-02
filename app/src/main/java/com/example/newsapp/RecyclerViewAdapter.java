package com.example.newsapp;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>
{
    private ArrayList<modelClass> typeList;
    private Context mcontext;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(modelClass item);
    }
    public RecyclerViewAdapter(ArrayList<modelClass> typeList, Context mcontext, OnItemClickListener listener) {
        this.typeList = typeList;
        this.mcontext = mcontext;
        this.listener = listener;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singletype, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        modelClass selectType = typeList.get(position);
        holder.type.setText(selectType.getName());
        holder.bind(selectType, listener);
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView type;
        private ConstraintLayout card;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            card = itemView.findViewById(R.id.card);
        }

        public void bind(modelClass modelClass, OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(modelClass);
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            card.setBackgroundColor(Color.GRAY);
                        }
                    }

                }
            });
        }
    }
}
