package com.csdn.fraglis.frag;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.csdn.fraglis.R;
import com.csdn.fraglis.listener.IndexListener;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class Frag2 extends Fragment implements IndexListener {

    private IndexListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag2, null);
        return view;
    }
    //初始化mListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (IndexListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IndexListener");
        }
    }
    @Override
    public void onIndexListener(String str, int i) {
        Toast.makeText(getActivity(),str+i,Toast.LENGTH_LONG).show();
    }
}
