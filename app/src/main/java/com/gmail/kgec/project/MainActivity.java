package com.gmail.kgec.project;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    public void btnC(View view) {

        //Input to execute function is to be changed
        new JsonTask().execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");

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
                br=new BufferedReader(new InputStreamReader(input));
                buf=new StringBuffer();
                while((line=br.readLine() )!=null){
                    buf.append(line);
                }
                return buf.toString();


            } catch (IOException e) {
                e.printStackTrace();
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

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //create Intent and send the String s to ResultView
        }

    }
}
