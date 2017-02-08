package com.gmail.kgec.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Saswati on 07-02-2017.
 */

public class DetailView extends AppCompatActivity
{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsview);


        Toast.makeText(getApplicationContext(), "thirdscreen", Toast.LENGTH_SHORT).show();
        final MoreDetails md1;
        md1 = (MoreDetails)getIntent().getSerializableExtra("MyClass");
        Toast.makeText(getApplicationContext(),md1.district,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),md1.pincode,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),md1.telephone,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),md1.nm,Toast.LENGTH_SHORT).show();
        LinearLayout tl = (LinearLayout) findViewById(R.id.ln3);
    }
}
