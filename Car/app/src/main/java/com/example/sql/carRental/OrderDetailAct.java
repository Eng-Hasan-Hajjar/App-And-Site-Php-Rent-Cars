package com.example.sql.carRental;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import LibClass.CustomBill;
//import LibClass.ListViewItemCheckboxBaseAdapter;
import LibClass.ListViewItemDTO;

import LibClass.oneRecordBill;
import LibClass.SqliteHelper;

public class OrderDetailAct extends Activity implements AsyncResponse{
    ListView lv;
List<oneRecordBill> AllBill;
    CustomAdapter adapter;
    ArrayList<String>  records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        lv = (ListView) findViewById(R.id.lvOrder);

        SqliteHelper s=new SqliteHelper(this);
       AllBill= s.GetAllProd();

        records=new ArrayList<String>();

        for(oneRecordBill temp:AllBill)
        {
            records.add(temp.toString());
        }
        adapter=new CustomAdapter(this,R.layout.list_item,R.id.pro_name,records);

        lv.setAdapter(adapter);

      //  listViewDataAdapter.notifyDataSetChanged();






        Button selectRemoveButton = (Button)findViewById(R.id.button6);


    }


    public void onclick(View v) {



        for(int i=0;i<AllBill.size();i++) {
            HashMap<String,String> postData= new HashMap<String, String>();
            postData.put("car", AllBill.get(i).car);
            postData.put("day", AllBill.get(i).num);
            postData.put("price", AllBill.get(i).price);
            PostResponseAsyncTask x= new PostResponseAsyncTask(this,postData);
            x.execute("http://192.168.43.95/carrent/sell.php");

        }




        }

    public void deleteRow(View view){
        SqliteHelper s=new SqliteHelper(this);
        Button bt=(Button)view;
        String del_id=bt.getTag().toString();
        for(int i=0;i<records.size();i++){
            if(records.get(i).startsWith(del_id)) {
                records.remove(i);
                AllBill.remove(i);
                Toast.makeText(this,AllBill.get(i).car+ " "+AllBill.get(i).num+" "+AllBill.get(i).price,Toast.LENGTH_LONG).show();

                s.delBill(AllBill.get(i).car);}
        }
        adapter.notifyDataSetChanged();

    }


    @Override
    public void processFinish(String s) {

    }
}