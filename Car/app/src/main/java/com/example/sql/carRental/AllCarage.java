package com.example.sql.carRental;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

import LibClass.Carage;
import LibClass.XMLParser;

public class AllCarage extends Activity implements AsyncResponse{
EditText ed1;
ListView lv1;
 ArrayList<Carage> allCarage;
    ArrayList<String> alls;
    ArrayAdapter arrr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_carage);
        ed1=(EditText)  findViewById(R.id.edSearchCarage);
        lv1=(ListView)   findViewById(R.id.lvcaragr);
        allCarage =new ArrayList<Carage>();
        alls=new ArrayList<String>();
          showAllCarage();
        
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                goCarage(position);

            }
        });
    }


    public void onclick(View v)
    {

        switch (v.getId())
        {
            case R.id.btSearch:
                if(!ed1.getText().toString().trim().equals(""))
                {

                    HashMap<String,String> postData= new HashMap<String, String>();
                    postData.put("src",ed1.getText().toString());
                    PostResponseAsyncTask x= new PostResponseAsyncTask(this);
                    x.execute("http://192.168.43.95/carrent/showSrcCarage.php");

                }

                break;

            case   R.id.btMyOrder:
                Intent intent =new Intent(this,OrderDetailAct.class);
                startActivity(intent);

                break;

            default:

        }

    }

public void logout(View v)
{
      SharedPreferences sp;
    sp=getSharedPreferences(MainActivity.spname, Context.MODE_PRIVATE) ;
    SharedPreferences.Editor ed =   sp.edit();
    ed.clear();

    ed.commit();
    Intent   intent =new Intent(this,MainActivity.class);

    startActivity(intent);
}

    void goCarage(int position)
    {
       Carage x =  allCarage.get(position);

        Intent   intent =new Intent(this,CarageDetailAct.class);

        intent.putExtra("id",x.id);
        intent.putExtra("name",x.name);
        intent.putExtra("region",x.Region);

        startActivity(intent);
    }


    void showAllCarage()
      {
         try {
             PostResponseAsyncTask x = new PostResponseAsyncTask(this);
           //  x.execute("http://192.168.43.95/carrent/showallCarage.php");
             x.execute("http://192.168.43.95/carrent/showallCarage.php");
         }
         catch(Exception e)
         {
             Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();

         }
      }

    @Override
    public void processFinish(String result) {
     //   Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        try {
            XMLParser parser = new XMLParser();

            Document doc = parser.getDomElement(result); // getting DOM element

            NodeList nl = doc.getElementsByTagName("carage");

            for (int i = 0; i < nl.getLength(); i++) {

                Carage d = new Carage();
                Element e = (Element) nl.item(i);
                d.id = e.getElementsByTagName("ParID").item(0).getTextContent();
                d.name = e.getElementsByTagName("name").item(0).getTextContent();
                d.Region = e.getElementsByTagName("reg").item(0).getTextContent();
                d.lat = e.getElementsByTagName("lat").item(0).getTextContent();
                d.lon = e.getElementsByTagName("lon").item(0).getTextContent();
                String s="               "+d.id+ "   "+d.name;
                alls.add(s);
                allCarage.add(d);
            }

            arrr=new ArrayAdapter<>(this,R.layout.tempc,R.id.tvvv,alls);
            lv1.setAdapter(arrr);

        }
        catch (Exception e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }

        // customLayout


    }
}
