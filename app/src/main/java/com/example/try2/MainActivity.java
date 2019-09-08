package com.example.try2;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static HttpURLConnection con;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button fab = findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder content;
                content = new StringBuilder();
                try{

                    Log.e("Owen","test");
                        String url = "http://owenserver.us.to:23654";
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);


                    URL myurl = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) myurl.openConnection();

                    con.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));

                    String line;
                    while ((line = in.readLine()) != null) {
                        content.append(line);
                        content.append(System.lineSeparator());
                    }
                    con.disconnect();
                    Log.e("Owen",content.toString());
                    updateTextView(content.toString());
                    view.invalidate();
                }
                catch (Exception e){
                    Log.e("Owen",e.toString());
                }
                //updateTextView(Long.toString(System.currentTimeMillis()));
            }
        });

        Button cust = findViewById(R.id.button7);
        cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder content;
                content = new StringBuilder();
                try{


                    Log.e("Owen", "LF");

                    String url = "http://owenserver.us.to:23654";
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);


                    URL myurl = new URL(url);
                    con = (HttpURLConnection) myurl.openConnection();
                    con.setDoOutput(true);
                    con.setRequestMethod("POST");

                    OutputStreamWriter out = new OutputStreamWriter(
                            con.getOutputStream());
                    EditText edit =  (EditText) findViewById(R.id.editText);
                    String temp = edit.getText().toString();
                    out.write(temp);
                    out.close();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    con.disconnect();
                    TextView tv3 = (TextView)findViewById(R.id.textView3);
                    tv3.setText(response.toString());

                }
                catch (Exception e){
                    Log.e("Owen",e.toString());
                }
                //updateTextView(Long.toString(System.currentTimeMillis()));
            }
        });
        Button res = findViewById(R.id.button8);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder content;
                content = new StringBuilder();
                try{


                    Log.e("Owen", "LF");

                    String url = "http://owenserver.us.to:23654";
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);


                    URL myurl = new URL(url);
                    con = (HttpURLConnection) myurl.openConnection();
                    con.setDoOutput(true);
                    con.setRequestMethod("POST");

                    OutputStreamWriter out = new OutputStreamWriter(
                            con.getOutputStream());

                    out.write("sudo_reset");
                    out.close();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    con.disconnect();
                    TextView tv3 = (TextView)findViewById(R.id.textView3);
                    tv3.setText(response.toString());
                    con.disconnect();
                }
                catch (Exception e){
                    Log.e("Owen",e.toString());
                }
                //updateTextView(Long.toString(System.currentTimeMillis()));
            }
        });
        Button reb = findViewById(R.id.button3);
        reb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder content;
                content = new StringBuilder();
                try{


                    Log.e("Owen", "LF");

                    String url = "http://owenserver.us.to:23654";
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);


                    URL myurl = new URL(url);
                    con = (HttpURLConnection) myurl.openConnection();
                    con.setDoOutput(true);
                    con.setRequestMethod("POST");

                    OutputStreamWriter out = new OutputStreamWriter(
                            con.getOutputStream());

                    out.write("sudo_reboot");
                    out.close();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    con.disconnect();
                    TextView tv3 = (TextView)findViewById(R.id.textView3);
                    tv3.setText(response.toString());
                    con.disconnect();
                }
                catch (Exception e){
                    Log.e("Owen",e.toString());
                }
                //updateTextView(Long.toString(System.currentTimeMillis()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void updateTextView(String toThis)
    {
        TextView tv = (TextView)findViewById(R.id.textView3);
        tv.setText(toThis);

    }
}
