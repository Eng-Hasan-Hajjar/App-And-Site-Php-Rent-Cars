package com.example.sql.carRental;

import android.app.Activity;
import android.content.Intent;
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

import LibClass.Car;
import LibClass.XMLParser;

public class CarAct extends Activity implements AsyncResponse {
    EditText ed1;
    ListView lv1;
    String id;
    String na;
    ArrayList<Car> allCar;
    ArrayList<String> allCarString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        Bundle b=   getIntent().getExtras();
        id=b.getString("id");

        Toast.makeText(this,id+"",Toast.LENGTH_LONG).show();
        allCar=new ArrayList<Car>();
        allCarString=new ArrayList<String>();
        ed1=(EditText)  findViewById(R.id.edSearchcar);
        lv1=(ListView)   findViewById(R.id.lvcars);

        showAllCar();

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                goCar(position);

            }
        });
    }

    public void onclick(View v)
    {

    if(!ed1.getText().toString().trim().equals(""))
         {
             HashMap<String,String> postData= new HashMap<String, String>();
             postData.put("src",ed1.getText().toString());
             PostResponseAsyncTask x= new PostResponseAsyncTask(this);
             x.execute("http://192.168.43.95/carrent/showSrcCar.php");
         }





    }



    void goCar(int position)
    {
        Car x =  allCar.get(position);

        Intent   intent =new Intent(this,CarDetailAct.class);
        intent.putExtra("id",x.CarID);
        intent.putExtra("name",x.CarName);
        intent.putExtra("model",x.CarModel);
        intent.putExtra("no",x.CarNo);
        intent.putExtra("price",x.carprice);
        intent.putExtra("reserve",x.isreserve);
        intent.putExtra("type",x.CarType);

        startActivity(intent);
    }

    void showAllCar()
    {

        HashMap<String,String> postData= new HashMap<String, String>();
        postData.put("id",id);
        PostResponseAsyncTask x= new PostResponseAsyncTask(this,postData);
        x.execute("http://192.168.43.95/carrent/showAllCar.php");
    }

    @Override
    public void processFinish(String result) {

        XMLParser parser = new XMLParser();

        Document doc = parser.getDomElement(result); // getting DOM element

        NodeList nl = doc.getElementsByTagName("car");


        for (int i = 0; i < nl.getLength(); i++) {


            Car d = new Car();

            Element e = (Element) nl.item(i);
            d.CarID = e.getElementsByTagName("CarID").item(0).getTextContent();
            d.CarName = e.getElementsByTagName("CarName").item(0).getTextContent();
            d.CarModel = e.getElementsByTagName("CarModel").item(0).getTextContent();

            d.CarType = e.getElementsByTagName("CarType").item(0).getTextContent();
            d.CarNo = e.getElementsByTagName("CarNo").item(0).getTextContent();
            d.carprice = e.getElementsByTagName("carprice").item(0).getTextContent();
            d.isreserve = e.getElementsByTagName("isreserve").item(0).getTextContent();

            allCar.add(d);
            allCarString.add("CarName:"+d.CarName+" Model:"+d.CarModel);

        }

        ArrayAdapter arrr=new ArrayAdapter<>(this,R.layout.tempcar,R.id.tvpCar,allCarString);
        lv1.setAdapter(arrr);

        // customLayout


    }





}
