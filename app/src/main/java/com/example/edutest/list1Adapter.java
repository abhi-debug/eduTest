package com.example.edutest;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list1Adapter extends RecyclerView.Adapter<list1Adapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> id;
    private ArrayList<String> name;
    private ArrayList<String> email;

    public list1Adapter(Context context, ArrayList<String> id, ArrayList<String> name, ArrayList<String> email) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list1,parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(id.get(position));
        holder.name.setText(name.get(position));
        holder.email.setText(email  .get(position));
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((SecondActivity) context).ItemClick();
            }
        });


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,email;
       LinearLayout click;
       ImageView svgimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            click=itemView.findViewById(R.id.click);
            svgimage=itemView.findViewById(R.id.svgimage);

        }
    }
}
