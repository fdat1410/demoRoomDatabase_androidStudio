package com.example.demoroomdatabase.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {
    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new FavouriteFragment();
            default: return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Số lượng Fragment
    }

}
