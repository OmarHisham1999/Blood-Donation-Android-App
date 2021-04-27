package com.example.blooddonation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FilterFragment extends Fragment {

    @Override
    @Nullable

    public void onStart() {
        super.onStart();
        Spinner bloodtypespinner = getView().findViewById(R.id.Bloodtpefilter);
        ArrayAdapter<CharSequence> bloodtypeadapter = ArrayAdapter.createFromResource(getContext(), R.array.bloodtype, android.R.layout.simple_spinner_item);
        bloodtypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodtypespinner.setAdapter(bloodtypeadapter);
        bloodtypespinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getContext());


        Spinner citiesspinner = getView().findViewById(R.id.cityfilter);
        ArrayAdapter<CharSequence> cityadapter = ArrayAdapter.createFromResource(getContext(), R.array.city, android.R.layout.simple_spinner_item);
        cityadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citiesspinner.setAdapter(cityadapter);
        citiesspinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getContext());


        final Spinner areaspinner = getView().findViewById(R.id.userareasignupspinner);


        citiesspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getContext().getApplicationContext(), R.array.cairoareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    //areaspinner.setOnItemSelectedListener(this);

                }

                if (position == 1) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getContext().getApplicationContext(), R.array.alexareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


                if (position == 2) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getContext().getApplicationContext(), R.array.sharmareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


                if (position == 3) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getContext().getApplicationContext(), R.array.hurgadaareas, android.R.layout.simple_spinner_item);

                    areaspinner.setAdapter(areasAdapter);


                }


                if (position == 4) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getContext().getApplicationContext(), R.array.portsaidareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


                if (position == 5) {
                    ArrayAdapter<CharSequence> areasAdapter = ArrayAdapter.createFromResource(getContext().getApplicationContext(), R.array.matrouhareas, android.R.layout.simple_spinner_item);
                    //areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(areasAdapter);
                    // areaspinner.setOnItemSelectedListener(this);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_filter, container,false);


    }
    }

