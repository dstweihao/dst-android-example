package com.jweihao.jdemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jweihao.jdemo.ui.fragment.MovieFragment;
import com.jweihao.jdemo.ui.fragment.MusicFragment;
import com.jweihao.jdemo.ui.fragment.NewsFargment;
import com.jweihao.jdemo.ui.fragment.SportsFargment;

/**
 * Created by weihao on 2017/12/18.
 */

public class FragPagerAdapter extends FragmentPagerAdapter {

    String[] mTitle = new String[]{"News","Sports","Movie","Music"};


    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 1) {
            return new SportsFargment();
        } else if (position == 2) {
            return new MovieFragment();
        } else if (position == 3) {
            return new MusicFragment();
        }

        return new NewsFargment();
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
