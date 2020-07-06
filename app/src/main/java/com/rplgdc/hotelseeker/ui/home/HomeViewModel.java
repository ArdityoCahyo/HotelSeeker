package com.rplgdc.hotelseeker.ui.home;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Destination");
    }

    public LiveData<String> getText() {
        return mText;
    }

}