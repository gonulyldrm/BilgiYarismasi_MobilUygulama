package com.example.bilgiiyarismasii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class KayitOl extends AppCompatActivity {

    Database db;
    EditText adsoyad;
    EditText email;
    EditText kullaniciadi;
    EditText sifre;
    EditText puan;
    Button kayitol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        adsoyad=(EditText)findViewById(R.id.adsoyad);
        email=(EditText)findViewById(R.id.email);
        kullaniciadi=(EditText)findViewById(R.id.kullaniciadi);
        sifre=(EditText)findViewById(R.id.sifre);
        kayitol=(Button) findViewById(R.id.kayitol);
        puan=(EditText) findViewById(R.id.puan);
        db=new Database(this);


        kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adsoyadd=adsoyad.getText().toString();
                String emaill=email.getText().toString();
                String kullaniciadii=kullaniciadi.getText().toString();
                String sifree =sifre.getText().toString();
                String puann=puan.getText().toString();

                if (adsoyadd.equals("") || sifree.equals("") || emaill.equals("")  ||  kullaniciadii.equals(""))
                    Toast.makeText(KayitOl.this,"alanlar boş bırakılamaz...!!!",Toast.LENGTH_LONG).show();
                else {

                            Boolean insert = db.veriekle(adsoyadd, emaill, kullaniciadii, sifree, puann);
                            if (insert = true) {
                                Toast.makeText(KayitOl.this, "başarıyla kaydolundu....! ", Toast.LENGTH_LONG).show();
                                Intent intentt=new Intent(getApplicationContext(),MainActivity.class);
                                intentt.putExtra("isim",adsoyadd);
                                startActivity(intentt);

                            } else {
                                Toast.makeText(KayitOl.this, "kayıt başarız oldu...! ", Toast.LENGTH_LONG).show();

                            }
                        }
                    }



        });
    }

}