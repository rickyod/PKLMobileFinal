package com.sparta.kami.pklmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Registrasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        Button btnBatal = (Button) findViewById(R.id.buttonBatal);
        Button btnSimpan = (Button) findViewById(R.id.buttonSimpan);

        btnBatal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Registrasi.this,Login.class);
                startActivity(i);
                finish();
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent i = new Intent(Registrasi.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void setDate(View view){
        PickerDialogs pickerDialogs = new PickerDialogs();
        pickerDialogs.show(getSupportFragmentManager(),"date_picker");
    }
}
