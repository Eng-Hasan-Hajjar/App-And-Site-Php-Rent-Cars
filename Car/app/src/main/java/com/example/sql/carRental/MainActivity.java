package com.example.sql.carRental;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class MainActivity extends Activity implements AsyncResponse  {
    EditText ed1,ed2;
   CheckBox  cb1;
  public  SharedPreferences sp;
   public final static String spname="Myshared";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1=(CheckBox) findViewById(R.id.checkBox);
        ed1=(EditText) findViewById(R.id.editText);
        ed2=(EditText) findViewById(R.id.editText2);

        sp=getSharedPreferences(spname, Context.MODE_PRIVATE) ;
    }




    public void    onclick  (View v)
    {
      String name=  ed1.getText().toString();
     String pass=   ed2.getText().toString();
       switch (v.getId())
       {
           case   R.id.button:
               if(ed1.getText().toString().equals("") ||ed2.getText().toString().equals("") )
               {
                   Toast.makeText(this,"There are empty Fields",Toast.LENGTH_LONG).show();
                   return;
               }


               HashMap<String,String> postData= new HashMap<String, String>();

               postData.put("nm",name);
               postData.put("ps",pass);


               PostResponseAsyncTask x= new PostResponseAsyncTask(this,postData);
               x.execute("http://192.168.43.95/carrent/login.php");




               break;

           case   R.id.button2:
               Intent   intent =new Intent(this,RegAct.class);
               startActivity(intent);
               break;

          default:

       }

    }



    protected void onResume() {
        if ( sp.contains("u")&&sp.contains("p"))
        {
            Intent x=new Intent(this,AllCarage.class);
            startActivity(x);

        }

        super.onResume();
    }


    @Override
    public void processFinish(String result) {
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        if(result.equals("1"))
        {

            if(cb1.isChecked())
            {
                SharedPreferences.Editor ed =   sp.edit();
                ed.putString("u",ed1.getText().toString());
                ed.putString("p",ed2.getText().toString());
                ed.commit();
            }

            Intent   intent =new Intent(this,AllCarage.class);




            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"You ara failed please .... ",Toast.LENGTH_LONG).show();
            ed1.setText("");
            ed2.setText("");

        }


    }

}
