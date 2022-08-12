package LibClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQL on 5/16/2018.
 */

public class SqliteHelper extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {

        String ct= "CREATE TABLE carBill (car TEXT,price TEXT,num TEXT);";
        db.execSQL(ct);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //
        db.execSQL("drop table if exists carBill");
        onCreate(db);

    }

    public SqliteHelper(Context c)
    {
        super(c,"carBill" +
                "" +
                "",null,1);
    }

    public List<oneRecordBill> GetAllProd()
    {

        List<oneRecordBill> res=new ArrayList<oneRecordBill>();

        String ct= "select * from carBill;";
        SQLiteDatabase db=       this.getReadableDatabase();
        Cursor cr=           db.rawQuery(ct,null);
        cr.moveToFirst();
        do
        {
            oneRecordBill pr=new oneRecordBill();
             pr.car=cr.getString(0);

            pr.price=cr.getString(2);
            pr.num=cr.getString(1);
            res.add(pr);


        }while (cr.moveToNext());




        return res;

    }

    public void addBill(oneRecordBill pr)
    {
        ContentValues val=new ContentValues();
        val.put("car",pr.car);
        val.put("price",pr.price);
        val.put("num",pr.num);

        SQLiteDatabase db=       this.getWritableDatabase();
        db.insert("carBill",null,val);


    }

    public void delBill(String name)
    {

        SQLiteDatabase db=       this.getWritableDatabase();
        db.delete("carBill", "car=" + name, null);


    }




}
