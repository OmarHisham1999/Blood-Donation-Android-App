package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

   /* @Override
    protected void onStart() {
        super.onStart();

         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String e = email.getText().toString();
                String p = password.getText().toString();

            }*/



        /*
        register = (TextView) findViewById(R.id.Registerusersignin);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openusersignup();
            }
        });


    }*/

    EditText demail;
    EditText dpassword;
    TextView loginbtn;
    TextView registerbtn;
    //FirebaseAuth fAuth;


  //  FirebaseUser currentUser ;
    private FirebaseAuth mAuth;


//    private void updateUI(FirebaseUser user) {
//
//        if (user == null) {
//            Toast.makeText(this,"No user Signed in",Toast.LENGTH_LONG).show();
//        }
//        else{
//            currentUser = user;
//            Toast.makeText(this,"User Signed in",Toast.LENGTH_LONG).show();
//        }
//    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        if (mAuth.getCurrentUser()!= null){
//            Intent intent = new Intent(Usersignup.this, MainActivity.class);
//            startActivity(intent);
//        }
//        currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //final UserDbHelper user = new UserDbHelper(this);

        demail = (EditText) findViewById(R.id.emailusersignin);
        dpassword = (EditText) findViewById(R.id.passwordusersignin);
        loginbtn = (TextView) findViewById(R.id.logintxtusersignin);
        registerbtn = (TextView) findViewById(R.id.Registerusersignin);

        mAuth = FirebaseAuth.getInstance();
       /*login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openuser();
           }
               String e=email.getText().toString();
               String p=password.getText().toString();
               Cursor cursor = user.Fetch_User(e, p);
               if (cursor.getCount()>0)
               {
                   Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();


               }
               else {
                   Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
               }

           }
       });*/

       /* register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openusersignup();
            }
        });*/


    }

    public void usergotoregister(View v) {

        Intent intent = new Intent(this, Usersignup.class);
        startActivity(intent);
    }


    public void userlogin(View v) {

        String email = demail.getText().toString().trim();
        String password = dpassword.getText().toString().trim();

        if(email.isEmpty()){
            demail.setError("Email is required");
            demail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            dpassword.setError("Email is required");
            dpassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();

                    if(user1.isEmailVerified()){
                    Toast.makeText(MainActivity.this,"Signed in Successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,UserHome.class);
                    startActivity(intent);}
                    else {
                        user1.sendEmailVerification();
                        Toast.makeText(MainActivity.this,"Check your Email",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"Please Check your credentials",Toast.LENGTH_LONG).show();

                }
            }
        });

        //authinticate Donor

//        fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this,"Welcome Helper",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(MainActivity.this, User.class);
//                    startActivity(intent);
//                }
//
//                else
//                {
//                    Toast.makeText(MainActivity.this,"Error !" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        });

//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Toast.makeText(MainActivity.this,"You are Signed in Succesfully",Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(MainActivity.this, User.class);
//                            startActivity(intent);
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                            String name = user.getDisplayName();
//                            intent.putExtra("name",name);


//                        } else {
//                            // If sign in fails, display a message to the user.
//
//                            Toast.makeText(MainActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });


    }


}

