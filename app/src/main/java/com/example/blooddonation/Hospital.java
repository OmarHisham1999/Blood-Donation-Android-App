package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Hospital extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout hdrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hdrawer = findViewById(R.id.drawer_hospital);
        NavigationView navigationView = findViewById(R.id.hnav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,hdrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        hdrawer.addDrawerListener(toggle);
        toggle.syncState();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddpostFreagent()).commit();
//        navigationView.setCheckedItem(R.id.hnav_addpost);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.hnav_addpost:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddpostFreagent()).commit();
            break;
            case R.id.hnav_email:
                Toast.makeText(this, "E-mail", Toast.LENGTH_SHORT).show();
                break;
        }

        hdrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (hdrawer.isDrawerOpen(GravityCompat.START)) {
            hdrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
