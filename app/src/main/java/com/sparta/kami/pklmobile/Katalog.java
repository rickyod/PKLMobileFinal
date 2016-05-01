package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Katalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
        Button btnKeluar = (Button) findViewById(R.id.buttonKeluar);
        Button btnTrans = (Button) findViewById(R.id.buttonTransaksi);
        Button btnTambah = (Button) findViewById(R.id.buttonTambah);

        btnKeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Katalog.this,SplashOut.class);
                startActivity(i);
                finish();
            }
        });

        btnTrans.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Katalog.this,Transaksi.class);
                startActivity(i);
                finish();
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Katalog.this,Produk.class);
                startActivity(i);
                finish();
            }
        });
    }

}
