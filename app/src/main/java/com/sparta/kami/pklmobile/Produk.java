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

public class Produk extends AppCompatActivity implements View.OnClickListener {

    private DataManipulator dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);
        Button btnKembali = (Button) findViewById(R.id.buttonKembali);
        Button btnTambah = (Button) findViewById(R.id.buttonTambah);
        Button btnSimpan = (Button) findViewById(R.id.buttonSimpan);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.buttonKembali:
                i = new Intent(Produk.this, Katalog.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonTambah:
                String nama = ((TextView)findViewById(R.id.editTextNamaProduk)).getText().toString();
                String hargaPokok = ((TextView)findViewById(R.id.editTextHargaPokok)).getText().toString();
                String hargaJual = ((TextView)findViewById(R.id.editTextHargaJual)).getText().toString();
                dm = new DataManipulator(this,"iProduk");
                dm.insertProduk(nama,hargaPokok,hargaJual);
                i = new Intent(Produk.this, Produk.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonSimpan:
                i = new Intent(Produk.this, Katalog.class);
                startActivity(i);
                finish();

        }
    }
}