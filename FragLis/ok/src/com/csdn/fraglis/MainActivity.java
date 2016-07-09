package com.csdn.fraglis;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.csdn.fraglis.adapter.FragAdapter;
import com.csdn.fraglis.listener.IndexListener;

public class MainActivity extends FragmentActivity implements IndexListener {

    private android.widget.TextView bt1;
    private android.widget.TextView bt2;
    private android.widget.TextView bt3;
    private android.support.v4.view.ViewPager viewpager;
    public FragAdapter fragAdapter;
    private IndexListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewpager = (ViewPager) findViewById(R.id.viewpager);
        this.bt3 = (TextView) findViewById(R.id.bt3);
        this.bt2 = (TextView) findViewById(R.id.bt2);
        this.bt1 = (TextView) findViewById(R.id.bt1);
        fragAdapter = new FragAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragAdapter);
        viewpager.setCurrentItem(0);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIndexListener("Call Back to My Implementer",0);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIndexListener("Call Back to My Implementer",1);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onIndexListener("Call Back to My Implementer",2);
            }
        });
    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        try {
            mListener = (IndexListener) fragment;
        } catch (ClassCastException e) {
            throw new ClassCastException(fragment.toString() + " must implement IndexListener");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onIndexListener(String str, int i) {
        Toast.makeText(MainActivity.this,str+i,Toast.LENGTH_LONG).show();
    }
}
