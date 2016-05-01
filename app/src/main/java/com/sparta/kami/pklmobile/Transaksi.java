package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Transaksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        Button btnKeluar = (Button) findViewById(R.id.buttonKeluar);
        Button btnRekap = (Button) findViewById(R.id.buttonRekap);
        Button btnKatalog = (Button) findViewById(R.id.buttonKatalog);

        btnKeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Transaksi.this,SplashOut.class);
                startActivity(i);
                finish();
            }
        });

        btnRekap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Transaksi.this,Rekap.class);
                startActivity(i);
                finish();
            }
        });

        btnKatalog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Transaksi.this,Katalog.class);
                startActivity(i);
                finish();
            }
        });
    }

}
