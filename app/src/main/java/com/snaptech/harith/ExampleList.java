package com.snaptech.harith;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.snaptech.R;
import com.snaptech.internet_con.Connect;

import java.util.ArrayList;
import java.util.List;



import static com.snaptech.internet_con.Connect.respons;

public class ExampleList extends RecyclerView.Adapter<ExampleList.ExampleViewHolder> {

    private onItemClickListener listener;

    public interface onItemClickListener
    {
void  onItemClick(int i);

    }
    
  public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }
     List<Halls> halls;
    Context context;
     public ExampleList(ArrayList<Halls> halls, Context context) {
        this.halls = halls;
        this.context=context;
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mText1;
        TextView mText2;
        TextView mLocation;
        public ExampleViewHolder(View itemView, final onItemClickListener listener, List<Halls> halls) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.hall_image_list);
            mText1 = itemView.findViewById(R.id.hall_name);
            mText2 = itemView.findViewById(R.id.hall_price);
            mLocation = itemView.findViewById(R.id.hall_location);
            Button more=itemView.findViewById(R.id.hall_more);
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "more", Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(listener!=null){
                       int i=getAdapterPosition();
                       if(i!=RecyclerView.NO_POSITION)
                           listener.onItemClick(i);
                   }

                }
            });
        }


    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ExampleViewHolder(v,listener, halls);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Halls current = halls.get(position);

       // holder.mImageView.setImageResource(current.getImageResource());

        holder.mText1.setText(current.getName());
        holder.mText2.setText(current.getAm_price());
        holder.mLocation.setText(current.getLocation());
    }

    @Override
    public int getItemCount() {
        return halls.size();
    }
}
