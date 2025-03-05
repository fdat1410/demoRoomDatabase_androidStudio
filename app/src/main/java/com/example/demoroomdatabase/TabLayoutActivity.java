package com.example.demoroomdatabase;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.demoroomdatabase.fragment.TabLayoutAdapter;
import com.example.demoroomdatabase.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabLayoutActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TabLayout Tablayout;
    ViewPager2 viewPager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Tablayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this);


        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(this);
        viewPager.setAdapter(tabLayoutAdapter);

        // Đồng bộ hóa TabLayout với ViewPager2
        new TabLayoutMediator(Tablayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Home");
                } else if (position == 1) {
                    tab.setText("Favourite");
                }
            }
        }).attach();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            viewPager.setAdapter(viewPagerAdapter);
            if (item.getItemId() == R.id.action_home) {
                viewPager.setCurrentItem(0);
                //selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.action_fav) {
                viewPager.setCurrentItem(1);
                //selectedFragment = new FavouriteFragment();
            } else if (item.getItemId() == R.id.action_profile) {
                viewPager.setCurrentItem(2);
                //selectedFragment = new ProfileFragment();
            }
            return true;
        });
    }
}