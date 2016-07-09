package com.csdn.fraglis.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.csdn.fraglis.frag.Frag1;
import com.csdn.fraglis.frag.Frag2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class FragAdapter extends FragmentPagerAdapter {


    List<Fragment> lists = new ArrayList<>();


    public FragAdapter(FragmentManager fm) {
        super(fm);

        Frag1 frag1 = new Frag1();

        Frag2 frag2 = new Frag2();

        lists.add(frag1);
        lists.add(frag2);
    }


   /* public FragAdapter(){

    }*/


    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
