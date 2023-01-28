package com.example.bilgiiyarismasii;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Sorularlist {


    @SuppressLint("Recycle")
    public ArrayList<Sorular>rastgele5sorugetir(Database vt){
        ArrayList<Sorular> sorulist=new ArrayList<>();
        SQLiteDatabase db=vt.getReadableDatabase();
        Cursor c = db.rawQuery("select * from sorular order by RANDOM() limit 5", null);
        while (c.moveToNext()){
            Sorular s;
            s = new Sorular(c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("soru")),c.getString(c.getColumnIndex("dogru")));
            sorulist.add(s);

        }
        return sorulist;
    }
    public ArrayList<Sorular>rastegele3yanlisgetir(Database vt, int id){
        ArrayList<Sorular> sorulist=new ArrayList<>();
        SQLiteDatabase db=vt.getReadableDatabase();
        Cursor c=db.rawQuery("select * from sorular where id != "+id+" order by RANDOM() limit 3",null);
        while (c.moveToNext()){
            Sorular s;
            s = new Sorular(c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("soru")),c.getString(c.getColumnIndex("dogru")));
            sorulist.add(s);

        }
        return sorulist;
    }
}
