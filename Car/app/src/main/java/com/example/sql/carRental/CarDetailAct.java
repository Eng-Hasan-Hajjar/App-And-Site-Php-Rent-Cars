package com.example.sql.carRental;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import LibClass.oneRecordBill;
import LibClass.SqliteHelper;

public class CarDetailAct extends Activity  {

    String id,name,no,model,price,reserve,type;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);
        price="";
        Bundle b=   getIntent().getExtras();
  ImageView im=(ImageView)  findViewById(R.id.imageView);

        id=b.getString("id");
        name= b.getString("name");
        model= b.getString("model");
        no=b.getString("no");
        price= b.getString("price");
        reserve= b.getString("reserve");
        type= b.getString("type");

        try {
            int resID = getResources().getIdentifier("car"+id,
                    "drawable", getPackageName());
            im.setImageResource(resID);


        }
        catch (Exception e)
        {

        }

Toast.makeText(this,id+name+model,Toast.LENGTH_LONG).show();
        ((TextView) findViewById(R.id.tv1)).setText("ID         "+id);
        ((TextView) findViewById(R.id.tv2)).setText("Name      "+name);
        ((TextView) findViewById(R.id.tv3)).setText("MODEL   "+model);
        ((TextView) findViewById(R.id.tv4)).setText("TYPE      "+type);
        ((TextView) findViewById(R.id.tv5)).setText("PRICE     "+price);
        ((TextView) findViewById(R.id.tv6)).setText("NO        "+no);
        ((TextView) findViewById(R.id.tv7)).setText("Resrve      "+reserve);
        ed1=(EditText)  findViewById(R.id.editText3);

    }



    public void   onclick(View v)
    {

        oneRecordBill b=new oneRecordBill();
        b.car=id;
        b.num=ed1.getText().toString();
        b.price=price;
        SqliteHelper s=new SqliteHelper(this);
        Toast.makeText(this,id+""+ b.num+""+price,Toast.LENGTH_LONG).show();
        s.addBill(b);

    }

}
