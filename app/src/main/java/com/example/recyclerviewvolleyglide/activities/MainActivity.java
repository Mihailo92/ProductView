package com.example.recyclerviewvolleyglide.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewvolleyglide.R;
import com.example.recyclerviewvolleyglide.adapters.RecyclerViewAdapter;
import com.example.recyclerviewvolleyglide.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Product> lstAnime;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstAnime = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();

    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0; i < response.length();i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        Product anime = new Product();
                        anime.setName(jsonObject.getString("name"));
                        anime.setBrand("Brand: "+jsonObject.getString("brand"));
                        anime.setPrice("Price: " + jsonObject.getString("price"));
                        anime.setImageURL(jsonObject.getString("image_link"));
                        lstAnime.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuoprecycleview(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuoprecycleview(List<Product> lstAnime) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}