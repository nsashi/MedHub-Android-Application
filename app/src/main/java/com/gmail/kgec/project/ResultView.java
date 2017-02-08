package com.gmail.kgec.project;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class ResultView extends AppCompatActivity {
    LinearLayout l1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultview);
        Toast.makeText(getApplicationContext(), "secondscreen..", Toast.LENGTH_SHORT).show();
        LinearLayout tl = (LinearLayout) findViewById(R.id.activity_listview);
        final LinearLayout.LayoutParams params;
        params = new LinearLayout.LayoutParams((int) LinearLayout.LayoutParams.MATCH_PARENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
        Intent i = getIntent();
        String hjason = i.getStringExtra("passarg");
        if (hjason == null) {
            Toast.makeText(getApplicationContext(), "String null..", Toast.LENGTH_SHORT).show();
        }

        try {
            JSONObject h = new JSONObject(hjason);
            JSONArray hname = h.getJSONArray("records");

            for (int j = 0; j < hname.length(); j++) {
                final JSONObject d = hname.getJSONObject(j);
                final String name = d.getString("Hospital_Name");
                GradientDrawable draw = new GradientDrawable();
                draw.setShape(GradientDrawable.RECTANGLE);
                draw.setStroke(3, Color.BLACK);
                draw.setCornerRadius(8);
                l1 = new LinearLayout(this);
                l1.setLayoutParams(params);
                l1.setPadding(8, 8, 8, 8);
                l1.setOrientation(LinearLayout.HORIZONTAL);
                //l1.setBackgroundColor(draw);
                final LinearLayout.LayoutParams param;
                param = (new LinearLayout.LayoutParams((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT));
                final TextView tr = new TextView(this);
                params.gravity = Gravity.CENTER_VERTICAL;
                tr.setLayoutParams(param);
                tr.setText(name);
                l1.addView(tr);
                tl.addView(l1);

                final Button btn = new Button(this);
                btn.setId(j + 1);
                btn.setText("More Details");
                btn.setLayoutParams(param);
                final MoreDetails md=new MoreDetails();


                    md.nm=name;
                    md.telephone=d.getString("Telephone");
                    md.state=d.getString("State");
                    md.location_cordinates=d.getString("Location_Coordinates");
                    md.location=d.getString("Location");
                    md.pincode=d.getString("Pincode");
                    md.district=d.getString("District");
                    md.mobilenumber=d.getString("Mobile_Number");
                    md.emergencynum=d.getString("Emergency_Num");
                    md.ambulancenum=d.getString("Ambulance_Phone_No");
                    md.bloodbankphn=d.getString("Bloodbank_Phone_No");
                    md.hospitalfax=d.getString("Hospital_Fax");
                    md.website=d.getString("Website");
                    md.specialities=d.getString("Specialties");
                    md.facilities=d.getString("Facilities");
                    md.numdoc=d.getString("Number_Doctor");
                    md.totbed=d.getString("Total_Num_Beds");
                    md.numprivateward=d.getString("Number_Private_Wards");


                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        Toast.makeText(getApplicationContext(),"entered onclick"+md.nm
                                ,Toast.LENGTH_SHORT).show();
                       Intent thirdscreen=new Intent(getApplicationContext(),DetailView.class);

                        thirdscreen.putExtra("MyClass",md);
                        startActivity(thirdscreen);

                    }
                });
                tl.addView(btn);
            }

        }
            catch (JSONException e) {
            System.out.println("Error in try catch");
            e.printStackTrace();
        }



    }


    }

