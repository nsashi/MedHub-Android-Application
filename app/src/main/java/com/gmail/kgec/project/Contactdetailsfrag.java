package com.gmail.kgec.project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Saswati on 09-02-2017.
 */

public class Contactdetailsfrag extends Fragment {
    TextView tx1,tx2,tx3,tx4,tx5;
    public Contactdetailsfrag()
    {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView=inflater.inflate(R.layout.detailview,container,false);
        super.onCreateView(inflater,container,savedInstanceState);
        return rootView;
    }
    public void settingvalues(String telephone,String mobile,String emergency,String ambulance,String bloodbankpn,String hospfax,String email,String website)
    {
        tx1=(TextView) getView().findViewById(R.id.tx2);
        tx1.setText(emergency);
        tx2=(TextView) getView().findViewById(R.id.tx3);
        tx2.setText(ambulance);
        tx4=(TextView) getView().findViewById(R.id.tx5);
        tx4.setText(telephone);
        tx3=(TextView) getView().findViewById(R.id.tx4);
        tx3.setText(mobile);
        tx5=(TextView) getView().findViewById(R.id.tx6);
        tx5.setText(bloodbankpn);
        tx5=(TextView) getView().findViewById(R.id.tx7);
        tx5.setText(hospfax);
        tx5=(TextView) getView().findViewById(R.id.tx8);
        tx5.setText(email);
        tx5=(TextView) getView().findViewById(R.id.tx9);
        tx5.setText(website);

    }
}

