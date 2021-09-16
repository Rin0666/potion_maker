package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionModel;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<LinearViewHolder> {
    private final ArrayList<PotionModel> data;

    public MyAdapter(Context context, ArrayList<PotionModel> data) {
        this.data = data;
    }

    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.potion_display, parent, false);

        return new LinearViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }
}