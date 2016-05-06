package com.sparta.kami.pklmobile;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class Registrasi extends AppCompatActivity implements View.OnClickListener{

    private PickerDialogs pickerDialog;

    String NAMESPACE = "http://schemas.xmlsoap.org/wsdl";
    String URL = "http://webtest.unpar.ac.id/pklws/pkl.php?wsdl";

    String SOAP_ACTION = "regpkl";
    String METHOD_NAME = "regpkl";

    //AlertDialog.Builder alertDialog;
    EditText editTextNama;
    EditText editTextAlamat;
    EditText editTextNomorHP;
    EditText editTextProduk;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        /*alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Registrasi");
        alertDialog.setMessage("Registrasi Berhasil");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // continue with delete
            }
        });
        alertDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
            }
        });*/

        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextNomorHP = (EditText) findViewById(R.id.editTextNomorHP);
        editTextProduk = (EditText) findViewById(R.id.editTextProduk);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

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
                SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
                String birthday = pickerDialog.getDate();
                request.addProperty("nama",editTextNama.getText().toString());
                request.addProperty("alamat",editTextAlamat.getText().toString());
                request.addProperty("nohp",editTextNomorHP.getText().toString());
                request.addProperty("produkunggulan",editTextProduk.getText().toString());
                request.addProperty("user",editTextEmail.getText().toString());
                request.addProperty("tgllahir",birthday);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTRansport = new HttpTransportSE(URL);
                try{
                    androidHttpTRansport.call(SOAP_ACTION, envelope);
                    SoapObject resultsRequestSOAP = (SoapObject)envelope.bodyIn;
                } catch (Exception e){
                    e.printStackTrace();
                }

                i = new Intent(Registrasi.this,Login.class);
                startActivity(i);
                finish();
                break;
        }
    }
}
