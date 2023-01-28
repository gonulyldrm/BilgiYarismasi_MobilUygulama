package com.example.bilgiiyarismasii;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String veritabaniad="veritabani";
    private static final int  versionn=1;


    public Database( Context context) {
        super(context,veritabaniad,null, versionn);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kullaniciar( adsoyad Text  ,email Text,kullaniciadi text,sifre Text,puan Text);");
        db.execSQL("CREATE TABLE sorular(id int ,soru Text,dogru Text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE İF EXİSTS kullaniciar");
        db.execSQL("DROP TABLE İF EXİSTS  sorular");
        onCreate(db);
    }
    public Boolean veriekle(String adsoyad,String email,String kullaniciad,String sifre,String puan){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("adsoyad",adsoyad);
        val.put("email",email);
        val.put("kullaniciadi", kullaniciad);
        val.put("sifre",sifre);
        val.put("puan",puan);

        long result =db.insert("kullaniciar",null,val);
        if (result==-1){ return false;}
        else{
            return true; }
    }
    public Boolean kullanicikontrol(String kullaniciadi){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from kullaniciar where kullaniciadi=?",new String[] {kullaniciadi});
        if (cursor.getCount()>0) return true;
        else
            return false;

    }
    public Boolean kullaniciadsifrekontrol(String kullaniciadi,String sifre){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from kullaniciar where kullaniciadi = ? and sifre = ?",new String[] {kullaniciadi,sifre});
        if (cursor.getCount()>0) return true;
        else
            return false;
    }
    public Boolean soruekle(String soru, String id, String dogru){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("id",id);
        val.put("soru",soru);
        val.put("dogru",dogru);

        long result =db.insert("sorular",null,val);
        if (result==-1){ return false;}
        else{
            return true; }
    }
    public boolean updateee(String kad,String puandegis){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("puan",puandegis);

        db.update("kullaniciar",cv,"kuullaniciadi=?",new String[] {kad});
        return true;


    }

}
