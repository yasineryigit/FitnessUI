package com.ossovita.fitnessui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.ossovita.fitnessui.Fragment.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_activity_view_pager);
        tabLayout = findViewById(R.id.main_activity_tab_layout);
        //adapteri tanımladık
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //yazdığımız ViewPagerAdapteri geldik sahibine verdik
        viewPager.setAdapter(viewPagerAdapter);
        //viewPageri tablayout'a bağladık
        tabLayout.setupWithViewPager(viewPager);
    }
}