package com.jy.myapplication.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jy.myapplication.Bean.JdbcBean;
import com.jy.myapplication.R;

import java.util.ArrayList;

public class RecyclerAdap extends RecyclerView.Adapter {
    private ArrayList<JdbcBean.ResultsDTO> list;
    private Context context;

    public RecyclerAdap(ArrayList<JdbcBean.ResultsDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_recy, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        JdbcBean.ResultsDTO resultsDTO = list.get(position);
        viewHolder.desc.setText(resultsDTO.getDesc());
        Glide.with(context).load(resultsDTO.getUrl()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView image;
        public TextView desc;

        public ViewHolder( View itemView) {
            super(itemView);
            this.view = view;
            this.image = (ImageView) itemView.findViewById(R.id.image);
            this.desc = (TextView) itemView.findViewById(R.id.desc);
        }
    }
}
