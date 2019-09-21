package com.example.edutest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class list2Adapter extends RecyclerView.Adapter<list2Adapter.MyViewHolder2> {
    Context context;
    ArrayList<String> date;
    ArrayList<String> amnt;

    public list2Adapter(Context context, ArrayList<String> date, ArrayList<String> amnt) {
        this.context = context;
        this.date = date;
        this.amnt = amnt;
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView date,amnt;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            amnt=itemView.findViewById(R.id.amnt);
        }
    }
    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list2,parent,false);
MyViewHolder2 vh=new MyViewHolder2(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.date.setText(date.get(position));
        holder.amnt.setText(amnt.get(position));

    }

    @Override
    public int getItemCount() {
        return date.size();
    }

}
