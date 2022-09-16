package com.example.recyclerviewvolleyglide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerviewvolleyglide.R;
import com.example.recyclerviewvolleyglide.activities.ProductActivity;
import com.example.recyclerviewvolleyglide.model.Product;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Product> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for GLide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item, parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sliku, brend, naziv i cenu
                Intent i = new Intent(mContext, ProductActivity.class);
                i.putExtra("name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("brand",mData.get(viewHolder.getAdapterPosition()).getBrand());
                i.putExtra("price",mData.get(viewHolder.getAdapterPosition()).getPrice());
                i.putExtra("picture",mData.get(viewHolder.getAdapterPosition()).getImageURL());

                mContext.startActivity(i);
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mData.get(position).getName());
        holder.brand.setText(mData.get(position).getBrand());
        holder.price.setText(mData.get(position).getPrice());

        //Load image from internet and set it into ImageView using Glide

        Glide.with(mContext).load(mData.get(position).getImageURL()).apply(option).into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView brand;
        TextView price;
        ImageView picture;
        LinearLayout view_container;

        public  MyViewHolder(View itemView){
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            name = itemView.findViewById(R.id.product_name);
            brand = itemView.findViewById(R.id.ar_brand);
            price = itemView.findViewById(R.id.ar_price);
            picture = itemView.findViewById(R.id.thumbnail);
        }
    }

}
