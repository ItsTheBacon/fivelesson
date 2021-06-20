package com.example.fivelesson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


   bottomNavigationView= findViewById(R.id.bottom_navigation);
   bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
           FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
           switch (item.getItemId()){
               case R.id.navigation_home:
                   transaction.replace(R.id.fragment_container, HomeFragment.newInstance("value1", "value2")).commit();
                   item.setChecked(true);
                   break;
               case R.id.navigation_list:
                   transaction.replace(R.id.fragment_container, listFragment.newInstance("value1", "value2")).commit();
                   item.setChecked(true);
                   break;
               case R.id.navigation_profil:
                   transaction.replace(R.id.fragment_container, PlofielFragment.newInstance("value1", "value2")).commit();
                   item.setChecked(true);
                   break;
           }
           return false;
       }
   });
//        fabopen_Taskfragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new AddnewTaskFragment()).commit();
//            //    getFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddnewTaskFragment).commit();
//
//            }
//        });

    }


}