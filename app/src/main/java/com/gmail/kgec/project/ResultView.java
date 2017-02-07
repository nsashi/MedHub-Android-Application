package com.gmail.kgec.project;

/**
 * Created by sourajit on 7/2/17.
 */

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultView extends AppCompatActivity {
    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultview);
        LinearLayout tl=(LinearLayout)findViewById(R.id.activity_listview);
        final LinearLayout.LayoutParams params;
        params = new LinearLayout.LayoutParams((int)LinearLayout.LayoutParams.MATCH_PARENT,(int)LinearLayout.LayoutParams.WRAP_CONTENT);
        Intent i = getIntent();
        String hjason = i.getStringExtra("passarg");
        try {
            JSONObject h = new JSONObject(hjason);
            JSONArray hname = h.getJSONArray("records");

            for (int j = 0; j < hname.length(); j++)
            {
                JSONObject d = hname.getJSONObject(j);
                String name = d.getString("Hospital_Name");
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
                        param=(new LinearLayout.LayoutParams((int)LinearLayout.LayoutParams.WRAP_CONTENT,(int)LinearLayout.LayoutParams.WRAP_CONTENT));
                TextView tr = new TextView(this);
                params.gravity= Gravity.CENTER_VERTICAL;
                tr.setLayoutParams(param);
                tr.setText(name);
                l1.addView(tr);
            }

            tl.addView(l1);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

