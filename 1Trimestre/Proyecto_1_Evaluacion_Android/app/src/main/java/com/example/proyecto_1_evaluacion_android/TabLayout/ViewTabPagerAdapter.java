package com.example.proyecto_1_evaluacion_android.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewTabPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitles = new ArrayList<>();

    public ViewTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public CharSequence getPageTitle(int position){
        return fragmentTitles.get(position);
    }

    public void addFragment (Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentTitles.add(title);
    }
}

