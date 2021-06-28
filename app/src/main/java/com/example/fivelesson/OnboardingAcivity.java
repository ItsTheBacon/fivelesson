package com.example.fivelesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.transition.Slide;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class OnboardingAcivity extends AppCompatActivity {
    private ViewPager viewPager;
    private OnBoardingAdapter onBoardingAdapter;
    private OnboardingModel onboardingModel;
    private WormDotsIndicator wormDotsIndicator;
    private TextView txtSkip, txtNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_acivity);
        viewPager = findViewById(R.id.view_pager);
        wormDotsIndicator = (WormDotsIndicator) findViewById(R.id.worm_dot);
        txtSkip = findViewById(R.id.txt_skip);
        txtNext = findViewById(R.id.txt_next);
        List<OnboardingModel> list = new ArrayList<>();
        list.add(new OnboardingModel("Welcome to Surf", "provide essential stuff for your ui desins every tuesday!", R.drawable.ic_baseline_settings_24));
        list.add(new OnboardingModel("Design Template uploads Every TuesDay!", "Make sure to take a look my uplab profile every tuesday", R.drawable.spring_dot_background));
        list.add(new OnboardingModel("Download now!", "You can follow me if you wantand comment on any to get some freebies ", R.drawable.ic_baseline_exit_to_app_24));
        onBoardingAdapter = new OnBoardingAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(onBoardingAdapter);
        wormDotsIndicator.setViewPager(viewPager);
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewPager.getCurrentItem();
                if (pos < list.size() - 1) {
                    pos++;
                    viewPager.setCurrentItem(pos);
                } else {
                    Intent intent = new Intent(OnboardingAcivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnboardingAcivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.commit();
        }
    }
}