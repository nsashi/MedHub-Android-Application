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

public class Facilitiesfrag extends Fragment {
    TextView tx1,tx2,tx3,tx4,tx5;
    public Facilitiesfrag()
    {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView=inflater.inflate(R.layout.detailview,container,false);
        super.onCreateView(inflater,container,savedInstanceState);
        return rootView;
    }
    public void settingvalues(String facilities,String specialities,String numdoc,String totbed,String numprivate)
    {
        tx1=(TextView) getView().findViewById(R.id.tx2);
        tx1.setText(facilities);
        tx2=(TextView) getView().findViewById(R.id.tx3);
        tx2.setText(specialities);
        tx4=(TextView) getView().findViewById(R.id.tx5);
        tx4.setText(numdoc);
        tx3=(TextView) getView().findViewById(R.id.tx4);
        tx3.setText(totbed);
        tx5=(TextView) getView().findViewById(R.id.tx6);
        tx5.setText(numprivate);
    }

}
