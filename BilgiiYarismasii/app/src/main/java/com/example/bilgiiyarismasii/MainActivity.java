package com.example.bilgiiyarismasii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {

    Button giris;
    Button kaydol,soruekle;
    EditText username;
    EditText password;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soruekle=(Button)findViewById(R.id.soruekle);
        giris=(Button)findViewById(R.id.giris);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        kaydol=(Button)findViewById(R.id.kaydol);
        db= new Database(this);

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sayfakaydol = new Intent(MainActivity.this,KayitOl.class);
                startActivity(sayfakaydol);
            }
        });
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamee=username.getText().toString();
                String passwordd=password.getText().toString();
                Boolean kontrolkullanicisiifre=db.kullaniciadsifrekontrol(usernamee,passwordd);
                if (kontrolkullanicisiifre)
                {
                    Toast.makeText(MainActivity.this,"Giriş Başarılı....!!!!",Toast.LENGTH_LONG).show();
                    Intent intenttt=new Intent(getApplicationContext(),sorularBolumu.class);
                    intenttt.putExtra("isimm",usernamee);
                    startActivity(intenttt);
                }
                else{
                    Toast.makeText(MainActivity.this,"Giriş Başarısız....!!!!",Toast.LENGTH_LONG).show();
                    username.getText().clear();
                    password.getText().clear();

                }

            }
        });
        soruekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle = new Intent(MainActivity.this,soruEkle.class);
                startActivity(ekle);
            }
        });


    }
}