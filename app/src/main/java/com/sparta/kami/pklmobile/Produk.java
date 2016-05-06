package com.sparta.kami.pklmobile;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Produk extends AppCompatActivity implements View.OnClickListener {

    private String NAMESPACE = "http://schemas.xmlsoap.org/wsdl";
    private String URL = "http://webtest.unpar.ac.id/pklws.pkl.php?wsdl";

    String SOAP_ACTION = "regproduk";
    String METHOD_NAME = "regproduk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_produk);
        Button btnKembali = (Button) findViewById(R.id.buttonPKembali);
        Button btnTambah = (Button) findViewById(R.id.buttonPTambah);
        Button btnSimpan = (Button) findViewById(R.id.buttonPSimpan);
    }

    @Override
    public void onClick(View view) {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        SoapSerializationEnvelope envelope;
        HttpTransportSE androidHttpTransport;

        Bundle b;
        Intent i;
        String sid;
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
                i = getIntent();
                b = i.getExtras();
                sid = b.getString("sid");

                nama = ((TextView)findViewById(R.id.editTextNamaProduk)).getText().toString();
                hargaPokok = ((TextView)findViewById(R.id.editTextHargaPokok)).getText().toString();
                hargaJual = ((TextView)findViewById(R.id.editTextHargaJual)).getText().toString();
                request.addProperty("sid",sid);
                request.addProperty("namaproduk",nama);
                request.addProperty("hargapokok",hargaPokok);
                request.addProperty("hargajual",hargaJual);

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);
                androidHttpTransport = new HttpTransportSE(URL);
                try{
                    androidHttpTransport.call(SOAP_ACTION,envelope);
                    SoapObject resultRequestSOAP = (SoapObject) envelope.bodyIn;
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                b= new Bundle();
                b.putString("sid",sid);
                i = new Intent(Produk.this, Produk.class);
                i.putExtras(b);
                startActivity(i);
                finish();
                break;

            case R.id.buttonPSimpan:
                i = getIntent();
                b = i.getExtras();
                sid = b.getString("sid");

                nama = ((TextView)findViewById(R.id.editTextNamaProduk)).getText().toString();
                hargaPokok = ((TextView)findViewById(R.id.editTextHargaPokok)).getText().toString();
                hargaJual = ((TextView)findViewById(R.id.editTextHargaJual)).getText().toString();
                request.addProperty("sid",sid);
                request.addProperty("namaproduk",nama);
                request.addProperty("hargapokok",hargaPokok);
                request.addProperty("hargajual",hargaJual);

                envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);
                androidHttpTransport = new HttpTransportSE(URL);
                try{
                    androidHttpTransport.call(SOAP_ACTION,envelope);
                    SoapObject resultRequestSOAP = (SoapObject) envelope.bodyIn;
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                b= new Bundle();
                b.putString("sid",sid);
                i = new Intent(Produk.this, Katalog.class);
                i.putExtras(b);
                startActivity(i);
                finish();

        }
    }
}