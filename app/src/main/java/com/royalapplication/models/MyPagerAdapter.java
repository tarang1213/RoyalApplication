package com.royalapplication.models;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.royalapplication.fragments.GalleryFragment;
import com.royalapplication.fragments.HomeFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager,tabCount);
        this.tabCount=tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:

            case 2:
                return new HomeFragment();

            case 1:
                return new GalleryFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
