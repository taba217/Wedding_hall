package com.example.wedding_hall.harith;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wedding_hall.R;

import java.util.List;

public class ExampleList extends RecyclerView.Adapter<ExampleList.ExampleViewHolder> {

     List<Halls> halls;
     ExampleList(List<Halls> halls) {
        this.halls = halls;
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mText1;
        TextView mText2;
        TextView mLocation;
        public ExampleViewHolder(View itemView, List<Halls> halls) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.hall_image_list);
            mText1 = itemView.findViewById(R.id.hall_name);
            mText2 = itemView.findViewById(R.id.hall_price);
            mLocation = itemView.findViewById(R.id.hall_location);
        }


    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ExampleViewHolder(v, halls);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Halls current = halls.get(position);
        holder.mImageView.setImageResource(current.getImageResource());
        holder.mText1.setText(current.getName());
        holder.mText2.setText(current.getPrice());
        holder.mLocation.setText(current.getLoocation());
    }
    @Override
    public int getItemCount() {
        return halls.size();
    }
}
