package com.gmail.kgec.project;

/**
 * Created by Saswati on 07-02-2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText edt;private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt=(EditText)findViewById(R.id.edit1);
    }
    public void sc1(View v) {
        String str = edt.getText().toString();
        str.toLowerCase();
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        // StringBuffer sb=new StringBuffer("https://data.gov.in/api/datastore/resource.json?resource_id=37670b6f-c236-49a7-8cd7-cc2dc610e32d&api-key=fabf9d77e3e39763802f22b2bc927d25&filters[%22District%22]="+str+"&fields=Location_Coordinates%2CLocation%2CHospital_Name%2CHospital_Category%2CHospital_Care_Type%2CDiscipline_Systems_of_Medicine%2CAddress_Original_First_Line%2CState%2CDistrict%2CSubdistrict%2CPincode%2CTelephone%2CMobile_Number%2CEmergency_Num%2CAmbulance_Phone_No%2CBloodbank_Phone_No%2CHospital_Fax%2CHospital_Primary_Email_Id%2CWebsite%2CSpecialties%2CFacilities%2CAccreditation%2CHospital_Regis_Number%2CNumber_Doctor%2CTotal_Num_Beds%2CNumber_Private_Wards&sort[Hospital_Name]=asc");
        StringBuffer sb=new StringBuffer("https://data.gov.in/api/datastore/resource.json?resource_id=37670b6f-c236-49a7-8cd7-cc2dc610e32d&api-key=fabf9d77e3e39763802f22b2bc927d25&filters[\"District\"]=");
        sb.append(str);
        sb.append("&fields=Location_Coordinates%2CLocation%2CHospital_Name%2CHospital_Category%2CHospital_Care_Type%2CDiscipline_Systems_of_Medicine%2CAddress_Original_First_Line%2CState%2CDistrict%2CSubdistrict%2CPincode%2CTelephone%2CMobile_Number%2CEmergency_Num%2CAmbulance_Phone_No%2CBloodbank_Phone_No%2CHospital_Fax%2CHospital_Primary_Email_Id%2CWebsite%2CSpecialties%2CFacilities%2CAccreditation%2CHospital_Regis_Number%2CNumber_Doctor%2CTotal_Num_Beds%2CNumber_Private_Wards&sort[Hospital_Name]=asc");
        final String url=sb.toString();
        dialog= ProgressDialog.show(MainActivity.this,"Searching","Please Wait!!!");
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                new JsonTask().execute(url);
            }
        });
        th.start();


    }
    class JsonTask extends AsyncTask<String,String,String> {
        HttpURLConnection con;
        BufferedReader br;
        StringBuffer buf;
        String line="";

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);

                con=(HttpURLConnection)url.openConnection();
                con.connect();
                InputStream input=con.getInputStream();
                dialog.dismiss();
                br=new BufferedReader(new InputStreamReader(input));
                buf=new StringBuffer();
                while((line=br.readLine() )!=null){
                    buf.append(line);
                }

                return buf.toString();


            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            finally {
                if(con !=null)
                    con.disconnect();
                try {
                    if(br!=null)
                        br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            Toast.makeText(getApplicationContext(),"firstscreen ",Toast.LENGTH_SHORT).show();
            String str="{\"help\":\"Search a datastore table. :param resource_id: id or alias of the data that is going to be selected.\",\"success\":false,\"total_records\":\"30273\",\"count\":0,\"fields\":{\"Location_Coordinates\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"255\",\"not null\":false,\"description\":\"\"},\"Location\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"255\",\"not null\":false,\"description\":\"\"},\"Hospital_Name\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"100\",\"not null\":false,\"description\":\"\"},\"Hospital_Category\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Hospital_Care_Type\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Discipline_Systems_of_Medicine\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Address_Original_First_Line\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"255\",\"not null\":false,\"description\":\"\"},\"State\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"30\",\"not null\":false,\"description\":\"\"},\"District\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Subdistrict\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Pincode\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"10\",\"not null\":false,\"description\":\"\"},\"Telephone\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Mobile_Number\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Emergency_Num\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Ambulance_Phone_No\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Bloodbank_Phone_No\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Hospital_Fax\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Hospital_Primary_Email_Id\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"100\",\"not null\":false,\"description\":\"\"},\"Website\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"255\",\"not null\":false,\"description\":\"\"},\"Specialties\":{\"type\":\"mediumblob\",\"size\":\"normal\",\"not null\":false,\"description\":\"\"},\"Facilities\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"255\",\"not null\":false,\"description\":\"\"},\"Accreditation\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Hospital_Regis_Number\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"50\",\"not null\":false,\"description\":\"\"},\"Number_Doctor\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"20\",\"not null\":false,\"description\":\"\"},\"Total_Num_Beds\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"10\",\"not null\":false,\"description\":\"\"},\"Number_Private_Wards\":{\"type\":\"varchar\",\"size\":\"normal\",\"length\":\"10\",\"not null\":false,\"description\":\"\"}},\"records\":[]}";
            if(s.equals(str))
                Toast.makeText(getApplicationContext()," no valid district enetered(check the spelling) ",Toast.LENGTH_SHORT).show();

            else {
                Intent nextscreen=new Intent(getApplicationContext(),ResultView.class);
                nextscreen.putExtra("passarg", s);
                startActivity(nextscreen);
            }
            //create Intent and send the String s to ResultView
        }

    }
}
