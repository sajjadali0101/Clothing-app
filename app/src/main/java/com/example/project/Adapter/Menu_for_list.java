package com.example.project.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.Cart;
import com.example.project.Model.Menu_list;
import com.example.project.R;

import java.util.ArrayList;

public class Menu_for_list extends RecyclerView.Adapter<Menu_for_list.ViewHolder> {
    ArrayList<Menu_list> list;
    Context context;

    public Menu_for_list(ArrayList<Menu_list> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cloth_menu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Menu_list Menu_ist = list.get(position);

        Glide.with(holder.imageurl.getContext()).load(Menu_ist.getImageUrl()).into(holder.imageurl);

        holder.rate.setText(Menu_ist.getRate());

        holder.description.setText(Menu_ist.getDescription());

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView rate, description;

        ImageView imageurl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imageurl=(ImageView) itemView.findViewById(R.id.image_1);

            rate=(TextView) itemView.findViewById(R.id.Rate);

            description=(TextView) itemView.findViewById(R.id.descp_1) ;}

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();

            Menu_list category = list.get(position);

            String Image = category.getImageUrl();

            String Descr = category.getDescription();

            String Rate = category.getRate();


            Intent in = new Intent(context, Cart.class);

            in.putExtra("image", Image);

            in.putExtra("description", Descr);

            in.putExtra("rate", Rate);

            context.startActivity(in);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}


