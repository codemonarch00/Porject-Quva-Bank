package com.example.zoomnride;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

            BottomNavigationView nav;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceFragment(new dashboard());

        nav = findViewById(R.id.bottomLayout);

      nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){
                  case R.id.homeIcon:
                      replaceFragment(new dashboard());
                      break;
                  case R.id.wallet:
                      break;
                  case R.id.sendToken:
                      break;
                  case R.id.profilePage:
                      replaceFragment(new profile_fragment());
                      break;
              }

              return true;
          }
      });
      nav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
          @Override
          public void onNavigationItemReselected(@NonNull MenuItem item) {

          }
      });
    }

    public boolean replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLay,fragment).addToBackStack(null);
        transaction.addToBackStack(null);
        transaction.commit();

        return false;
    }

    @Override
    public void onBackPressed() {
        if(!getSupportFragmentManager().popBackStackImmediate()){
            super.onBackPressed();
        }

    }
}