package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Choose extends AppCompatActivity {
     ImageButton hospital;
     ImageButton user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        hospital = (ImageButton) findViewById(R.id.hospitalbtnchoose);
        user = (ImageButton) findViewById(R.id.userbtnchoose);
    }



    public void openhospital (View v){
        Intent myIntent = new Intent(this, Hospitalsignin.class);
        startActivity(myIntent);
    }


    public void openuser (View v){
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }



   /* public void openhospital() {
        Intent intent = new Intent(this, Hospitalsignin.class);
        startActivity(intent);
    }

    public void openuser(){
        Intent intentu = new Intent(this,MainActivity.class);
        startActivity(intentu);
    }*/



}
