package com.example.accout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.accout.Model.Expenditure;
import com.example.accout.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private int mResource;
    private List<Expenditure> expenditureList;

    public RecyclerAdapter(Context mContext, int mResource, List<Expenditure> expenditureList) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.expenditureList = expenditureList;
    }

    @Override
    public int getItemCount() {
        return expenditureList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       Expenditure expenditure = expenditureList.get(position);

        holder.name.setText(expenditure.name);
        holder.money.setText(expenditure.money+" บาท");
        holder.img.setImageResource(expenditure.img);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource,parent,false);
        return new MyViewHolder(view);
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView money;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.list_name);
            this.money = itemView.findViewById(R.id.money_list);
            this.img = itemView.findViewById(R.id.moneyLogo);
        }

    }

}
