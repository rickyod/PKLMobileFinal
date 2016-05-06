package com.sparta.kami.pklmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class Registrasi extends AppCompatActivity implements View.OnClickListener{

    private PickerDialogs pickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        Button btnBatal = (Button) findViewById(R.id.buttonBatal);
        Button btnSimpan = (Button) findViewById(R.id.buttonSimpan);
        btnBatal.setOnClickListener(this);
        btnSimpan.setOnClickListener(this);
    }

    public void setDate(View view){
        pickerDialog = new PickerDialogs();
        pickerDialog.show(getSupportFragmentManager(),"date_picker");
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.buttonBatal:
                i = new Intent(Registrasi.this,Login.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonSimpan:
                String email = ((TextView)findViewById(R.id.editTextEmail)).getText().toString();
                String name = ((TextView)findViewById(R.id.editTextNama)).getText().toString();
                String address = ((TextView)findViewById(R.id.editTextAlamat)).getText().toString();
                String number = ((TextView)findViewById(R.id.editTextNomorHP)).getText().toString();
                String birthday = pickerDialog.getDate();
                String product = ((TextView)findViewById(R.id.editTextProduk)).getText().toString();

                i = new Intent(Registrasi.this,Login.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
