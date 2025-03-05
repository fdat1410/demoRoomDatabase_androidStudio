package com.example.demoroomdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.demoroomdatabase.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ViewPager extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_pager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bottomNavigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.action_home) {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(0);
                //selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.action_fav) {
                Toast.makeText(this, "Favourite", Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(1);
                //selectedFragment = new FavouriteFragment();
            } else if (item.getItemId() == R.id.action_profile) {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(2);
                //selectedFragment = new ProfileFragment();
            }
            return true;
        });
    }
}