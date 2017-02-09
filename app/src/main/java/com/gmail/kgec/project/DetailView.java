package com.gmail.kgec.project;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailView extends AppCompatActivity
{

    TextView t;

    String item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsview);
        Toast.makeText(getApplicationContext(), "thirdscreen", Toast.LENGTH_SHORT).show();
        final MoreDetails md1;
        md1 = (MoreDetails) getIntent().getSerializableExtra("MyClass");
        t = (TextView) findViewById(R.id.hos_name);
        t.setText(md1.nm);
        t = (TextView) findViewById(R.id.l2);
        t.setText(md1.location_cordinates);
        t = (TextView) findViewById(R.id.l3);
        t.setText(md1.address);
        t = (TextView) findViewById(R.id.l4);
        t.setText(md1.district);
        t = (TextView) findViewById(R.id.l5);
        t.setText(md1.state);
        t = (TextView) findViewById(R.id.l6);
        t.setText(md1.pincode);
        t = (TextView) findViewById(R.id.C2);
        t.setText(md1.emergencynum);
        t = (TextView) findViewById(R.id.C3);
        t.setText(md1.ambulancenum);
        t = (TextView) findViewById(R.id.C4);
        t.setText(md1.telephone);
        t = (TextView) findViewById(R.id.C5);
        t.setText(md1.mobilenumber);
        t = (TextView) findViewById(R.id.C6);
        t.setText(md1.bloodbankphn);
        t = (TextView) findViewById(R.id.C7);
        t.setText(md1.email);
        t = (TextView) findViewById(R.id.C8);
        t.setText(md1.website);
        t = (TextView) findViewById(R.id.C9);
        t.setText(md1.hospitalfax);
        t = (TextView) findViewById(R.id.f2);
        t.setText(md1.specialities);
        t = (TextView) findViewById(R.id.f3);
        t.setText(md1.numdoc);
        t = (TextView) findViewById(R.id.f4);
        t.setText(md1.totbed);
        t = (TextView) findViewById(R.id.f5);
        t.setText(md1.numprivateward);
        t = (TextView) findViewById(R.id.f6);
        t.setText(md1.facilities);







    }







}
