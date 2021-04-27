package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class updatepostactivity extends AppCompatActivity {

    Spinner bloodtypespinner, statusspinner;
    EditText numberofdonors, patientname;
    TextView addpost;
    String hospitalmail,location;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepostactivity);

        bloodtypespinner = findViewById(R.id.bloodtypeaddpost);
        statusspinner = findViewById(R.id.statusaddpost);
        numberofdonors = findViewById(R.id.numberofdonorsaddpost);
        patientname = findViewById(R.id.patientnameaddpost);
        addpost = findViewById(R.id.addpost);

        hospitalmail = getIntent().getExtras().getString("hospitalemail","defaultKey");
        location = getIntent().getExtras().getString("location","defaultKey");
        name = getIntent().getExtras().getString("patient","defaultKey");

        if(!name .equals("Key")){
            patientname.setText(name);
        }


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
                        Toast.makeText(updatepostactivity.this,"Data Updated Successfylly", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
