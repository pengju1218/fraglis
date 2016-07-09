package com.csdn.fraglis.frag;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.csdn.fraglis.R;
import com.csdn.fraglis.listener.IndexListener;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class Frag1 extends Fragment implements IndexListener {
    private IndexListener mListener;
    private android.widget.TextView bt5;
    private android.widget.TextView bt6;
    private android.widget.TextView bt7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag1, null);
        this.bt7 = (TextView) view.findViewById(R.id.bt7);
        this.bt6 = (TextView) view.findViewById(R.id.bt6);
        this.bt5 = (TextView) view.findViewById(R.id.bt5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIndexListener("Call Back to My activity Implementer",1000);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIndexListener("Call Back to My activity Implementer",2000);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIndexListener("Call Back to My activity Implementer",3000);
            }
        });
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
