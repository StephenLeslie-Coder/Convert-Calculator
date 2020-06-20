package com.example.convertcalculator;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int myNumOfTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm);
        myNumOfTabs=behavior;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new tab1();
            case 1: return new tab2();
            case 2: return new tab3();
            case 3:return new tab4();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return myNumOfTabs;
    }
}
