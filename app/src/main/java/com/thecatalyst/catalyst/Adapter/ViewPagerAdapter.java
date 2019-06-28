package com.thecatalyst.catalyst.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.thecatalyst.catalyst.Fragment.ChatFragment;
import com.thecatalyst.catalyst.Fragment.CompletedFragment;
import com.thecatalyst.catalyst.Fragment.CurrentFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position ==0) {
            return new CurrentFragment();
        }else if (position == 1) {
            return new CompletedFragment();
        }
        return new  ChatFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }


}
