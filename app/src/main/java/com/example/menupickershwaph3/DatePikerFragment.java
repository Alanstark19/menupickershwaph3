package com.example.menupickershwaph3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DatePikerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatePikerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

@NonNull
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker.
final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it.
        return new DatePickerDialog(getActivity(), this, year, month, day);
        }

/**
 * Grabs the date and passes it to processDatePickerResult().
 *
 * @param datePicker  The date picker view
 * @param year  The year chosen
 * @param month The month chosen
 * @param day   The day chosen
 */
@Override
public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        // Set the activity to the Main Activity.
        activity_order activity = (activity_order) getActivity();
        // Invoke Main Activity's processDatePickerResult() method.
        activity.processDatePickerResult(year, month, day);
        }
}