package com.example.bilgiiyarismasii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class sorularBolumu extends AppCompatActivity {

    Button a,b,c,d;
    TextView soru,al,hosgeldin,dogrusayacc,sorusayacc,yanlissayacc,puandegisimic;
    private ArrayList<Sorular> sorulist;
    private ArrayList<Sorular> yanlissecenekler;
    private Sorular dogrusoru;
    private Database vt;
    private int sorusayac=0;
    private int yanlissayac=0;
    private int dogrusayac=0;
    private int puanssayac=0;
    private HashSet<Sorular> karistirmaa=new HashSet<>();
    private ArrayList<Sorular> seceneks=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorular_bolumu);

        dogrusayacc=(TextView)findViewById(R.id.dogrusayisi);
        puandegisimic=(TextView)findViewById(R.id.puandegisimi);
        yanlissayacc=(TextView)findViewById(R.id.yanlissayisi);
        sorusayacc=(TextView)findViewById(R.id.sorusayisi);
        al=(TextView)findViewById(R.id.al);
        soru=(TextView)findViewById(R.id.soru);
        hosgeldin=(TextView)findViewById(R.id.textView3);
        hosgeldin.setText("Hosgeldın");
        a=(Button)findViewById(R.id.a);
        b=(Button)findViewById(R.id.b);
        c=(Button)findViewById(R.id.c);
        d=(Button)findViewById(R.id.d);

        vt =new Database(this);

        sorulist=new Sorularlist().rastgele5sorugetir(vt);
        soruyukle();



        Intent intent = getIntent();
        String ad=intent.getStringExtra("isim");
        al.setText(ad);
        String add=intent.getStringExtra("isimm");
        al.setText(add);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogrukontrol(a);
                sayackontrol();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogrukontrol(a);
                sayackontrol();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogrukontrol(a);
                sayackontrol();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogrukontrol(a);
                sayackontrol();
            }
        });


    }
    public  void soruyukle(){
        sorusayacc.setText((sorusayac+1)+" . Soru");
        dogrusayacc.setText("Dogru: "+dogrusayac);
        yanlissayacc.setText("YAnlis: "+yanlissayac);
        puandegisimic.setText("Ypuan: "+puanssayac);

        dogrusoru=sorulist.get(sorusayac);
        yanlissecenekler= new Sorularlist().rastegele3yanlisgetir(vt,dogrusoru.getId());

        soru.setText(dogrusoru.getSoru());

        karistirmaa.clear();
        karistirmaa.add(dogrusoru);
        karistirmaa.add(yanlissecenekler.get(0));
        karistirmaa.add(yanlissecenekler.get(1));
        karistirmaa.add(yanlissecenekler.get(2));

        seceneks.clear();

        for(Sorular s:karistirmaa) seceneks.add(s);

        a.setText(seceneks.get(0).getDogru());
        b.setText(seceneks.get(1).getDogru());
        c.setText(seceneks.get(2).getDogru());
        d.setText(seceneks.get(3).getDogru());
    }
    public void dogrukontrol(Button buton) {
        String butonyazi=buton.getText().toString();
        String dogrucevap=dogrusoru.getDogru();
        if (butonyazi.equals(dogrucevap)){
            dogrusayac ++;
            puanssayac=puanssayac+10;
        }else {
            yanlissayac ++;
        }
        dogrusayacc.setText("Dogru: "+dogrusayac);
        yanlissayacc.setText("YAnlis: "+yanlissayac);
        puandegisimic.setText("Ypuan: "+puanssayac);
    }
    public void sayackontrol(){
        sorusayac++;
        if(sorusayac !=5){
            soruyukle();
        }else {
            vt.updateee(al.toString(),puandegisimic.toString());
            Toast.makeText(sorularBolumu.this,"Bilgi yarismasi sona erdi...!",Toast.LENGTH_LONG).show();
            finish();
        }

    }
}