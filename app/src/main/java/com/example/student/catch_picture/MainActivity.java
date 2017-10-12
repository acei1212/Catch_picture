package com.example.student.catch_picture;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import static com.example.student.catch_picture.R.id.imageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        ImageRequest request1 = new ImageRequest(
                "http://images.all-free-download.com/images/graphiclarge/butterfly_flower_01_hd_pictures_166973.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ImageView iv = (ImageView) findViewById(imageView);
                        iv.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request1);
        queue.start();

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        Picasso.with(this)
                .load("http://images.all-free-download.com/images/graphiclarge/pink_flowers_with_bees_hd_picture_166824.jpg")
                .into(imageView);
    }
}