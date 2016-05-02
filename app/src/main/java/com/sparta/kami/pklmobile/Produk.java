package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Produk extends AppCompatActivity implements View.OnClickListener {

    private DataManipulator dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);
        Button btnKembali = (Button) findViewById(R.id.buttonPKembali);
        Button btnTambah = (Button) findViewById(R.id.buttonPTambah);
        Button btnSimpan = (Button) findViewById(R.id.buttonPSimpan);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        String nama;
        String hargaPokok;
        String hargaJual;
        switch (view.getId()) {
            case R.id.buttonPKembali:
                i = new Intent(Produk.this, Katalog.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonPTambah:
                nama = ((TextView)findViewById(R.id.editTextNamaProduk)).getText().toString();
                hargaPokok = ((TextView)findViewById(R.id.editTextHargaPokok)).getText().toString();
                hargaJual = ((TextView)findViewById(R.id.editTextHargaJual)).getText().toString();
                dm = new DataManipulator(this,"iProduk");
                dm.insertProduk(nama,hargaPokok,hargaJual);
                i = new Intent(Produk.this, Produk.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonPSimpan:
                Log.d("Click", "onClick: Simpan");
                nama = ((TextView)findViewById(R.id.editTextNamaProduk)).getText().toString();
                hargaPokok = ((TextView)findViewById(R.id.editTextHargaPokok)).getText().toString();
                hargaJual = ((TextView)findViewById(R.id.editTextHargaJual)).getText().toString();
                dm = new DataManipulator(this,"iProduk");
                dm.insertProduk(nama,hargaPokok,hargaJual);
                i = new Intent(Produk.this, Katalog.class);
                Log.d("Click", "onClick: Simpan2");
                startActivity(i);
                finish();

        }
    }
}