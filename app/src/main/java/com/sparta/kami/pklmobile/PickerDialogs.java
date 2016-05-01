package com.sparta.kami.pklmobile;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Yod on 4/24/2016.
 */
public class PickerDialogs extends DialogFragment{

    private DateSettings ds;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ds = new DateSettings(getActivity());
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(getActivity(),ds,year,month,day);
        return dialog;
    }

    public String getDate(){
        return ds.date;
    }
}
