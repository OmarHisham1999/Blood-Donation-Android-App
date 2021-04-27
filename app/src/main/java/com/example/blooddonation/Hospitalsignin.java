package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class Hospitalsignin extends AppCompatActivity {
    EditText enteredemail, enteredpassword;
    TextView signin;
    String location;

   private FirebaseAuth mAuth;
    //private TextView openhospital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_hospitalsignin);
        //final UserDbHelper hospital = new UserDbHelper(this);
        enteredpassword=(EditText)findViewById(R.id.passwordhospitalsignin);
        enteredemail=(EditText)findViewById(R.id.emailhospitalsignin);
        signin = (TextView) findViewById(R.id.logintxtsignin);
        location = getIntent().getExtras().getString("reglocation","defaultKey");;
        mAuth = FirebaseAuth.getInstance();
        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhospital();
                String e = email.getText().toString();
                String p = password.getText().toString();
                Cursor cursor = hospital.Fetch_User(e, p);
                if (cursor.getCount() > 0) {
                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }

            }

            }
            });*/

       /* openhospital = (TextView) findViewById(R.id.Registersignin);
        openhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhospitalsignup();
            }
        });*/


    }

    public void openhospital(View v){

        final String email = enteredemail.getText().toString().trim();
        String password = enteredpassword.getText().toString().trim();
        final String hospitallocation = location;

        if(email.isEmpty()){
            enteredemail.setError("Email is required");
            enteredemail.requestFocus();
            return;
        }

//        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
//        {
//            enteredemail.setError("Please Enter a Valid E-mail");
//            enteredemail.requestFocus();
//            return;
//        }

        if(password.isEmpty()){
            enteredpassword.setError("Password is required");
            enteredpassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser hospital = FirebaseAuth.getInstance().getCurrentUser();

                    if(hospital.isEmailVerified()){
                        Toast.makeText(Hospitalsignin.this,"Signed in Successfully",Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(Hospitalsignin.this, HospitalHome.class);
                        myIntent.putExtra("email",email);
                        myIntent.putExtra("location",hospitallocation);
                        startActivity(myIntent);
                    }
                    else{
                        hospital.sendEmailVerification();
                        Toast.makeText(Hospitalsignin.this,"Check your Email",Toast.LENGTH_LONG).show();

                    }


                }
                else
                {
                    Toast.makeText(Hospitalsignin.this,"Failed please try again",Toast.LENGTH_LONG).show();

                }
            }
        });


    }


    public void openhospitalsignup(View v) {
        Intent myIntent = new Intent(this, Hospitalsignup.class);
        startActivity(myIntent);
    }
}