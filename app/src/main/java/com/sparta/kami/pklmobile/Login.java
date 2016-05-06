package com.sparta.kami.pklmobile;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {

    String NAMESPACE = "http://schemas.xmlsoap.org/wsdl";
    String URL = "http://webtest.unpar.ac.id/pklws/pkl.php?wsdl";

    String SOAP_ACTION = "login";
    String METHOD_NAME = "login";
    EditText editTextUserName;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        Button btnLogin = (Button) findViewById(R.id.buttonLogin);
        Button btnRegis = (Button) findViewById(R.id.buttonRegistrasi);

        btnLogin.setOnClickListener(this);
        btnRegis.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent i;
        Bundle b;

        switch (v.getId()) {
            case R.id.buttonRegistrasi:
                i = new Intent(Login.this, Registrasi.class);
                startActivity(i);
                finish();
                break;
            case R.id.buttonLogin:
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

                request.addProperty("username", editTextUserName.getText().toString());
                request.addProperty("password", editTextPassword.getText().toString());

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTRansport = new HttpTransportSE(URL);

                try {
                    androidHttpTRansport.call(SOAP_ACTION, envelope);
                    SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
                    String record;
                    record = resultsRequestSOAP.getProperty(0).toString();
                    record = (record.substring(2, record.length() - 1) + ",");
                    String response = "";
                    String sid = "";
                    int index = 1;
                    int prevPointer = 0;
                    for (int j = 0; j < record.length(); j++) {
                        if (record.charAt(j) == ',') {
                            if (index == 1) {
                                response = record.substring(prevPointer, j - 1);
                            }
                            if (index == 2) {
                                sid = record.substring(prevPointer, j - 1);
                                System.out.println(sid);
                            }
                            prevPointer = j + 2;
                            index++;
                        }
                    }
                    if (response.equals("OK")) {
                        b = new Bundle();
                        b.putString("sid",sid);
                        i = new Intent(Login.this, Katalog.class);
                        i.putExtras(b);
                        startActivity(i);
                        finish();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



        }
    }

}
