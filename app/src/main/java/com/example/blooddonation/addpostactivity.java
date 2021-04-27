package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class addpostactivity extends AppCompatActivity {


    Spinner bloodtypespinner, statusspinner;
    EditText numberofdonors, patientname;
    TextView addpost;
    String hospitalmail,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpostactivity);

        bloodtypespinner = findViewById(R.id.bloodtypeaddpost);
        statusspinner = findViewById(R.id.statusaddpost);
        numberofdonors = findViewById(R.id.numberofdonorsaddpost);
        patientname = findViewById(R.id.patientnameaddpost);
        addpost = findViewById(R.id.addpost);

        location = getIntent().getExtras().getString("location","defaultKey");
        hospitalmail = getIntent().getExtras().getString("hospitalemail","defaultKey");

        ArrayAdapter<CharSequence> bloodtypeadapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_item);
        bloodtypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodtypespinner.setAdapter(bloodtypeadapter);


        ArrayAdapter<CharSequence> statusadapter = ArrayAdapter.createFromResource(this, R.array.status, android.R.layout.simple_spinner_item);
        statusadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusspinner.setAdapter(statusadapter);


        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberofDonors = numberofdonors.getText().toString();
                String hospitallocation = location;
                String hospitalemail = hospitalmail;
                //String d = descriptione.getText().toString();
                String patient = patientname.getText().toString();

                String bloodtype = bloodtypespinner.getSelectedItem().toString();
                String status = statusspinner.getSelectedItem().toString();

                PostDBHelper post = new PostDBHelper(bloodtype, status, numberofDonors, patient, hospitalemail,hospitallocation);

                FirebaseDatabase.getInstance().getReference("Posts").child(patient).setValue(post).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(addpostactivity.this,"Post Added Successfylly", Toast.LENGTH_LONG).show();
                    }
                });

                Intent myintent = new Intent(addpostactivity.this,HospitalHome.class);
                myintent.putExtra("patientname",patient);
                startActivity(myintent);

            }
        });
    }
}
