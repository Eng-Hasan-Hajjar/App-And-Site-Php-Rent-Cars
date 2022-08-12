package com.example.sql.carRental;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.*;

import java.util.HashMap;

public class RegAct extends Activity implements AsyncResponse {
EditText  ed1,ed2,ed3,ed4,ed5,ed6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        ed1=(EditText) findViewById(R.id.edname);
        ed2=(EditText) findViewById(R.id.edPass);
        ed3=(EditText) findViewById(R.id.edpass2);

        ed4=(EditText) findViewById(R.id.edemail);

        ed5=(EditText) findViewById(R.id.edphone);
        ed6=(EditText) findViewById(R.id.edAdd);


    }

    public void onclick(View v)
    {

        if(ed1.getText().toString().equals("") ||ed2.getText().toString().equals("")
                ||ed3.getText().toString().equals("")
                ||ed4.getText().toString().equals("")
                ||ed5.getText().toString().equals("")
                ||ed6.getText().toString().equals("")

                )
        {
            Toast.makeText(this,"There are empty Fields",Toast.LENGTH_LONG).show();
            return;
        }
         if(!ed2.getText().toString().equals(ed3.getText().toString()))
        {
            Toast.makeText(this,"Passwords are not same",Toast.LENGTH_LONG).show();
            Toast.makeText(this,ed2.getText().toString()+ed3.getText().toString()+ed1.getText().toString(),Toast.LENGTH_LONG).show();

            return;
        }

        //to do   php

        HashMap<String,String> postData= new HashMap<String, String>();

        postData.put("nm",ed1.getText().toString());
        postData.put("ps",ed2.getText().toString());
        postData.put("em",ed4.getText().toString());
        postData.put("ph",ed5.getText().toString());
        postData.put("ad",ed6.getText().toString());
       Toast.makeText(this,ed2.getText().toString()+ed3.getText().toString()+ed1.getText().toString(),Toast.LENGTH_LONG).show();
        PostResponseAsyncTask x= new PostResponseAsyncTask(this,postData);
        x.execute("http://192.168.43.95/carrent/register.php");

    }

    @Override
    public void processFinish(String result) {
        if(result=="1")
        {
            Toast.makeText(this,"You ara Registered  successfuly",Toast.LENGTH_LONG).show();

            Intent   intent =new Intent(this, MainActivity.class);
            startActivity(intent);

        }

    }
}
