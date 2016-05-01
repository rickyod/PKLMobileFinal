package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Rekap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekap);
        Button btnKeluar = (Button) findViewById(R.id.buttonKeluar);
        Button btnTrans = (Button) findViewById(R.id.buttonTransaksi);
        Button btnKtlg = (Button) findViewById(R.id.buttonKatalog);

        btnKeluar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Rekap.this,SplashOut.class);
                startActivity(i);
                Rekap.this.finish();
                System.exit(0);
            }
        });

        btnTrans.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Rekap.this,Transaksi.class);
                startActivity(i);
                finish();
            }
        });

        btnKtlg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Rekap.this,Katalog.class);
                startActivity(i);
                finish();
            }
        });

    }

}
