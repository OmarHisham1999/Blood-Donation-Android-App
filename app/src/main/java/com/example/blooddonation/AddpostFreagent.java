package com.example.blooddonation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.FirebaseDatabase;

public class AddpostFreagent extends Fragment {

    Spinner bloodtype, status;
    EditText numberofdonors, description, patient;



    @Override
    public void onStart() {
        super.onStart();
             //final UserDbHelper post = new UserDbHelper(getContext());
         final Spinner bloodtypespinner = getView().findViewById(R.id.bloodtypeaddpost);
        final Spinner statusspinner = getView().findViewById(R.id.statusaddpost);
         final EditText numberofdonorse = getView().findViewById(R.id.numberofdonorsaddpost);
         final EditText patientnamee = getView().findViewById(R.id.patientnameaddpost);
        final TextView addpost = getView().findViewById(R.id.addpost);

        ArrayAdapter<CharSequence> bloodtypeadapter = ArrayAdapter.createFromResource(getContext(), R.array.bloodtype, android.R.layout.simple_spinner_item);
        bloodtypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodtypespinner.setAdapter(bloodtypeadapter);


        ArrayAdapter<CharSequence> statusadapter = ArrayAdapter.createFromResource(getContext(), R.array.status, android.R.layout.simple_spinner_item);
        statusadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusspinner.setAdapter(statusadapter);

     addpost.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String numberofdonors = numberofdonorse.getText().toString();

             //String d = descriptione.getText().toString();
             String patientname = patientnamee.getText().toString();

             String bloodtype = bloodtypespinner.getSelectedItem().toString();
             String status = statusspinner.getSelectedItem().toString();

           //  PostDBHelper post = new PostDBHelper(bloodtype,status,numberofdonors,patientname);

            // FirebaseDatabase.getInstance().getReference("Posts").child(patientname).setValue(post);
//             if (nof.equals("") || d.equals("") || pn.equals("") || bl.equals("") || st.equals("") )
//             {
//                 Toast.makeText(getContext(), "Fill all fields", Toast.LENGTH_LONG).show();
//             }
//             else
//                 {
//
//                 post.CreateNewPost(bl,st,nof,d,pn);
//                 Toast.makeText(getView().getContext(), "Done", Toast.LENGTH_LONG).show();
//
//             }
         }


     });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addppost, container, false);

        return view;
    }

}