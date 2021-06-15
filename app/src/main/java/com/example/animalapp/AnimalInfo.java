package com.example.animalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalInfo extends AppCompatActivity {

    ImageView img;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_info);
        img = findViewById(R.id.imgCircled);
        txt = findViewById(R.id.animal_name);

        Intent intent = getIntent();

        img.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));

    }
}
