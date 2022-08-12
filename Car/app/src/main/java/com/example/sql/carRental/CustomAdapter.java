package com.example.sql.carRental;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    int groupid;
    ArrayList<String> records;
    Context context;

    public CustomAdapter(Context context, int vg, int id, ArrayList<String> records){
        super(context,vg, id, records);
        this.context=context;
        groupid=vg;
        this.records=records;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(groupid, parent, false);
        String[] row_items=records.get(position).split("__");
        TextView textName= (TextView) itemView.findViewById(R.id.pro_name);
        textName.setText(row_items[1]);
        TextView textPrice= (TextView) itemView.findViewById(R.id.pro_uprice);
        textPrice.setText(row_items[2]+"$");
        Button bt_del=(Button)itemView.findViewById(R.id.bt_delete);
        bt_del.setTag(row_items[0]);
        return itemView;
    }
}