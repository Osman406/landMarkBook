package com.osman.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.osman.landmarkbook.MainActivity.selectedImage;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView landMarkName;
    TextView countryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView=findViewById(R.id.imageView);
        landMarkName=findViewById(R.id.landMarkName);
        countryName=findViewById(R.id.countryName);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String country=intent.getStringExtra("country");
        landMarkName.setText(name);
        countryName.setText(country);
       imageView.setImageBitmap(selectedImage);



    }
}