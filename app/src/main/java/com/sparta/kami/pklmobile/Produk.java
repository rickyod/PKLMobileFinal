package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Produk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);
        Button btnKembali = (Button) findViewById(R.id.buttonKembali);
        Button btnTambah = (Button) findViewById(R.id.buttonTambah);
        Button btnSimpan = (Button) findViewById(R.id.buttonSimpan);

        btnKembali.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Produk.this,Katalog.class);
                startActivity(i);
                finish();
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Produk.this,Produk.class);
                startActivity(i);
                finish();
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Produk.this,Katalog.class);
                startActivity(i);
                finish();
            }
        });
    }

}
