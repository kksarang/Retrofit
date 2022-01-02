package com.example.retrofitfullfill.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitfullfill.R;

public class CourseActivity extends AppCompatActivity {

    TextView RealPrize;
    ImageView img_thumb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        RealPrize=findViewById(R.id.textView4);

        RealPrize.setText(getIntent().getStringExtra("prize"));

        img_thumb = findViewById(R.id.imageofthumbils);

   //     img_thumb.setImageResource(getIntent().getIntExtra("image",0));

        Glide.with(img_thumb.getContext()).load(getIntent().getStringExtra("image")).into(img_thumb);

    }


}