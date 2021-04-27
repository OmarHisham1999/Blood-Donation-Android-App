package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Usersignup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText regname, regpassword, regemail, regphone;
    Spinner regbloodtype, regcity, regarea;
    TextView signup;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    FirebaseUser currentUser ;
    private FirebaseAuth mAuth;


    private void updateUI(FirebaseUser user) {

        if (user == null) {
            Toast.makeText(this,"No user Signed in",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        if (mAuth.getCurrentUser()!= null){
//            Intent intent = new Intent(Usersignup.this, MainActivity.class);
//            startActivity(intent);
//        }
        currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersignup);


        //final UserDbHelper user = new UserDbHelper(this);
        regname = (EditText) findViewById(R.id.usernamesignup);
        regpassword = (EditText) findViewById(R.id.userpasswordsignup);
        regphone = (EditText) findViewById(R.id.phoneusersignup);
        regemail = (EditText) findViewById(R.id.emailusersignup);
        regbloodtype = (Spinner) findViewById(R.id.userbloodtypesignupspinner);
        regcity = (Spinner) findViewById(R.id.usercitysignupspinner);
        regarea = (Spinner) findViewById(R.id.userareasignupspinner);
        signup = (TextView) findViewById(R.id.usersignuplogintxt);

        /*signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String p = password.getText().toString();
                String ph = phone.getText().toString();
                String e = email.getText().toString();
                String bl = bloodtype.getSelectedItem().toString();
                String c = city.getSelectedItem().toString();
                String a = area.getSelectedItem().toString();
                if (n.equals("") || e.equals("") || p.equals("") || ph.equals("") || bl.equals("") || c.equals("") || a.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_LONG).show();
                } else {

                   long ret= user.CreateNewUser(n,e,p,ph,bl,c,a);
                    if(ret!=-1)
                    {
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();


                        openusersignin();
                    }

                }
            }

        });*/


//--------------------------------------------------------------------------------------------------------------------------
        final Spinner bloodtypespinner = findViewById(R.id.userbloodtypesignupspinner);
        ArrayAdapter<CharSequence> bloodtypeadapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_item);
        bloodtypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodtypespinner.setAdapter(bloodtypeadapter);
        bloodtypespinner.setOnItemSelectedListener(this);


        Spinner citiesspinner = findViewById(R.id.usercitysignupspinner);
        ArrayAdapter<CharSequence> cityadapter = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_item);
        cityadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citiesspinner.setAdapter(cityadapter);
        citiesspinner.setOnItemSelectedListener(this);


        final Spinner areaspinner = findViewById(R.id.userareasignupspinner);

        citiesspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.cairoareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    //areaspinner.setOnItemSelectedListener(this);

                }

                if (position == 1) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.alexareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


                if (position == 2) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.sharmareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


                if (position == 3) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.hurgadaareas, android.R.layout.simple_spinner_item);

                    areaspinner.setAdapter(areasAdapter);


                }


                if (position == 4) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.portsaidareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


                if (position == 5) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.matrouhareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //------------------------------------------------------------------------------------------------------------------------------------
        mAuth = FirebaseAuth.getInstance();



    }




    public void openusersignin(View v) {

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Donors");




        //Get all the values

        final String name = regname.getText().toString().trim();
        final String password = regpassword.getText().toString().trim();
        final String email = regemail.getText().toString().trim();
        final String phone = regphone.getText().toString().trim();
        final String bloodtype = regbloodtype.getSelectedItem().toString().trim();
        final String city = regcity.getSelectedItem().toString().trim();
        final String area = regarea.getSelectedItem().toString().trim();


        if(name.isEmpty()){
            regname.setError("Name is required");
            regname.requestFocus();
            return;
        }
        if(password.isEmpty()){
            regpassword.setError("Name is required");
            regpassword.requestFocus();
            return;
        }
        if(phone.isEmpty()){
            regphone.setError("Name is required");
            regphone.requestFocus();
            return;
        }
        if(email.isEmpty()){
            regemail.setError("Name is required");
            regemail.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    DonorsDBHelper user = new DonorsDBHelper(name,password,phone,email,bloodtype,city,area);

                    FirebaseDatabase.getInstance().getReference("Donors")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Usersignup.this,"Donor Registered Successfully",Toast.LENGTH_LONG).show();

                            }
                            else {
                                Toast.makeText(Usersignup.this,"Donor Registeration Failed",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }else {
                    Toast.makeText(Usersignup.this,"Error! registeration Failed",Toast.LENGTH_LONG).show();

                }
            }
        });


//        DonorsDBHelper donorhelper = new DonorsDBHelper(name,password,email,phone,bloodtype,city,area);
//
//        reference.child(phone).setValue(donorhelper);

        // Register the user

//        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Usersignup.this,new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    updateUI(user);
//                    Toast.makeText(Usersignup.this,"You are Registered Succesfully",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(Usersignup.this, MainActivity.class);
//                    startActivity(intent);
//                }
//                else {
////                    Toast.makeText(Usersignup.this,"You are NOTTTTTT Registered Succesfully",Toast.LENGTH_LONG).show();
//                    Toast.makeText(Usersignup.this,"Error ! "+task.getException().getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        });

//        Toast.makeText(Usersignup.this,"You are Registered Succesfully",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(Usersignup.this, MainActivity.class);
//                    startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
