package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class HospitalHome extends AppCompatActivity {
    String hospitalemail,location;
    CardView addpost, updatepost;
    String patientname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_home);
        addpost = findViewById(R.id.openaddpost);
        updatepost = findViewById(R.id.openupdatepost);

        hospitalemail = getIntent().getExtras().getString("email","defaultKey");
        location = getIntent().getExtras().getString("location","defaultKey");
        patientname = getIntent().getExtras().getString("patientname","Key");


    }
    public void openaddpost (View v)
    {
        Intent myintent = new Intent(HospitalHome.this,addpostactivity.class);
        myintent.putExtra("hospitalemail",hospitalemail);
        myintent.putExtra("location",location);
        startActivity(myintent);

    }

    public void openuppdatepost(View v){
        Intent myintent = new Intent(HospitalHome.this,updatepostactivity.class);
        myintent.putExtra("hospitalemail",hospitalemail);
        myintent.putExtra("patient",patientname);
        myintent.putExtra("location",location);
        startActivity(myintent);
    }

    public void Logout(View view) {
        Intent myintent = new Intent(HospitalHome.this,Choose.class);
        startActivity(myintent);
    }
}
