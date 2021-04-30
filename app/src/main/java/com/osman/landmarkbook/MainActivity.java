package com.osman.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.listView);
        ArrayList<String> landmarkNames=new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Collesseo");
        landmarkNames.add("London Bridge");
        ArrayList<String> countryName=new ArrayList<>();
        countryName.add("Italy");
        countryName.add("France");
        countryName.add("Italy");
        countryName.add("England");
        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap collesseo= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colleseo);
        Bitmap londonbridge= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);
        ArrayList<Bitmap> images=new ArrayList<>();
        images.add(pisa);
        images.add(eiffel);
        images.add(collesseo);
        images.add(londonbridge);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(position));
                intent.putExtra("country",countryName.get(position));
               selectedImage=images.get(position);
                startActivity(intent);


            }
        });


    }
}