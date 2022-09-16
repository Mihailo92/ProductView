package com.example.recyclerviewvolleyglide.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerviewvolleyglide.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;



public class ProductActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().hide();

        String name = getIntent().getExtras().getString("name");
        String brand = getIntent().getExtras().getString("brand");
        String price = getIntent().getExtras().getString("price");
        String picture = getIntent().getExtras().getString("picture");

        /*CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);*/

        TextView prod_name = findViewById(R.id.aa_product_name);
        TextView prod_brand = findViewById(R.id.aa_brand);
        TextView prod_price = findViewById(R.id.aa_price);
        ImageView prod_picture = findViewById(R.id.aa_thumbnail);

        prod_name.setText(name);
        prod_brand.setText(brand);
        prod_price.setText(price);

        //collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(picture).apply(requestOptions).into(prod_picture);
    }
}