package com.example.bilgiiyarismasii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class soruEkle extends AppCompatActivity {

    EditText soru,dogru,id;
    Database db;
    Button ekle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_ekle);
        ekle = (Button)findViewById(R.id.button);

        soru=(EditText)findViewById(R.id.soru);
        db=new Database(this);
        dogru=(EditText)findViewById(R.id.dogru);
        id=(EditText)findViewById(R.id.id);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idd=id.getText().toString();
                String soruu=soru.getText().toString();
                String dogruu=dogru.getText().toString();
                if (soruu.equals("") || dogruu.equals("") || idd.equals("") )
                    Toast.makeText(soruEkle.this,"alanlar boş bırakılamaz...!!!",Toast.LENGTH_LONG).show();
                else {
                    Boolean insert = db.soruekle(soruu,idd,dogruu);
                    if (insert = true) {
                        Toast.makeText(soruEkle.this, "başarıyla kaydolundu....! ", Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(soruEkle.this, "kayıt başarız oldu...! ", Toast.LENGTH_LONG).show();

                    }}
            }



        });
    }

}