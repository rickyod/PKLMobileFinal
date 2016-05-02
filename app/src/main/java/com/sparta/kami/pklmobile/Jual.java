package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jual extends AppCompatActivity implements View.OnClickListener {

    private DataManipulator dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual);
        Button btnBatal = (Button) findViewById(R.id.buttonBatal);
        Button btnSimpan = (Button) findViewById(R.id.buttonSimpan);

        btnBatal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Jual.this,Transaksi.class);
                startActivity(i);
                finish();
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Jual.this,Transaksi.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.buttonBatal:
                i = new Intent(Jual.this,Transaksi.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonSimpan:
                i = new Intent(Jual.this,Transaksi.class);
                startActivity(i);
                finish();
                break;

        }
    }
}
