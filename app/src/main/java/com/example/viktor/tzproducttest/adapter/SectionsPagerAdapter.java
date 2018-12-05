package com.example.viktor.tzproducttest.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.viktor.tzproducttest.view.fragment.PlaceholderLoad;
import com.example.viktor.tzproducttest.view.fragment.PlaceholderSave;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    List<String> fragmentNamesList;

    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragmentList,
                                List<String> fragmentNamesList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.fragmentNamesList = fragmentNamesList;
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {



        return fragmentNamesList.get(position);
    }
}
