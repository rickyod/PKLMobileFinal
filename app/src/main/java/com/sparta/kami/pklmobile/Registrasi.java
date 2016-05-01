package com.sparta.kami.pklmobile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registrasi extends AppCompatActivity implements View.OnClickListener{

    private DataManipulator dm;
    private DatePickerDialog datePickerDialog;

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
        PickerDialogs pickerDialogs = new PickerDialogs();
        datePickerDialog = (DatePickerDialog) pickerDialogs.getDialog();
        pickerDialogs.show(getSupportFragmentManager(),"date_picker");
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
                String birthday = ""+datePickerDialog.getDatePicker().getDayOfMonth()+datePickerDialog.getDatePicker().getMonth()+datePickerDialog.getDatePicker().getYear();
                String product = ((TextView)findViewById(R.id.editTextProduk)).getText().toString();

                this.dm = new DataManipulator(this);
                Log.d("Debug Registration",email+" "+name+" "+address+" "+number+" "+birthday+" "+product);
                //this.dm.insertRegisUser(email,name,address,number,birthday,product);
                i = new Intent(Registrasi.this,Login.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
