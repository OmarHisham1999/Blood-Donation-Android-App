package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Hospitalsignup extends AppCompatActivity {
    EditText regemail,regpassword,regregisterationno,reglocation;
    TextView signup;
    TextView gotosignin;

    private FusedLocationProviderClient fusedLocationProviderClient;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalsignup);
        //final UserDbHelper DbHelper = new UserDbHelper(this);

        regemail=(EditText)findViewById(R.id.signupemail);
        regpassword=(EditText)findViewById(R.id.signuppassword);
        regregisterationno=(EditText)findViewById(R.id.signupregistrationnumber);
        reglocation = (EditText)findViewById(R.id.signuplocation);
        signup = (TextView) findViewById(R.id.logintxthospitalsignup);

        mAuth = FirebaseAuth.getInstance();



        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        /*signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                String rn = registeration.getText().toString();
                Long res=DbHelper.CreateNewHospital(e,p,rn);
                if(res!=-1)
                {
                    Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    openhospitalsignin();
                }

            }
        } );*/

    }



    public void openhospitalsignin(View v){
        final  String email = regemail.getText().toString().trim();
        final  String password = regpassword.getText().toString().trim();
        final  String registrationNo = regregisterationno.getText().toString().trim();
        final  String location = reglocation.getText().toString().trim();

        if(email.isEmpty()){
            regemail.setError("Email is required");
            regemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            regpassword.setError("Password is required");
            regpassword.requestFocus();
            return;
        }
        if(registrationNo.isEmpty()){
            regregisterationno.setError("Registration Number is required");
            regregisterationno.requestFocus();
            return;
        }

        if(location.isEmpty()){
            reglocation.setError("Location is required");
            reglocation.requestFocus();
            return;
        }




        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    HospitalDBHelper hospital = new HospitalDBHelper(email,password,registrationNo,location);

                    FirebaseDatabase.getInstance().getReference("Hospitals")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(hospital).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Hospitalsignup.this,"Hospital has been Registered succesfully",Toast.LENGTH_LONG).show();

                                //

                            }
                            else {
                                Toast.makeText(Hospitalsignup.this,"Failed please try again",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
                else {
                    Toast.makeText(Hospitalsignup.this,"Failed to register",Toast.LENGTH_LONG).show();

                }
            }
        });


        Intent intent = new Intent(this, Hospitalsignin.class);
        intent.putExtra("reglocation",location);
        startActivity(intent);
    }

    public void getlocation(View view) {


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED){
                // GET LOCATION
                fusedLocationProviderClient.getLastLocation()
                        .addOnSuccessListener(new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {

                                if (location !=null){

                                    Double lat = location.getLatitude();
                                    Double longt = location.getLongitude();
                                    reglocation.setText(lat+" , "+longt);
                                    Toast.makeText(Hospitalsignup.this,"Location retreived",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
            else{
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }
        }

    }
}