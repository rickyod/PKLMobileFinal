package com.sparta.kami.pklmobile;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Yod on 4/24/2016.
 */
public class DateSettings implements DatePickerDialog.OnDateSetListener {
    Context context;
    public DateSettings(Context context){
        this.context = context;
    }
    String date;

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context,"Selected date :"+dayOfMonth+" / "+monthOfYear+" / "+year,Toast.LENGTH_LONG).show();
        String day= "";
        String month = "";
        if((monthOfYear+1)<10){
            month = "0"+(monthOfYear+1);
        }
        else{
            month = ""+(monthOfYear+1);
        }
        if(dayOfMonth<10){
            day = "0"+dayOfMonth;
        }
        else{
            day = ""+dayOfMonth;
        }
        date = day+month+year;
    }
}
