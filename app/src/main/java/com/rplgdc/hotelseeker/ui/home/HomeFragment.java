package com.rplgdc.hotelseeker.ui.home;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rplgdc.hotelseeker.R;
import com.rplgdc.hotelseeker.RoomActivity;
import com.rplgdc.hotelseeker.SearchActivity;

import java.util.Calendar;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;
    private LinearLayout datePicker;
    private LinearLayout roomPicker;
    private Button searchButton;

    private String textDate1;
    private String textDate2;
    private TextView textDate;
    private TextView textroom;

    public int day1,month1,year1;
    public int day2,month2,year2;
    public String date1;
    public String date2;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        Intent intent = new Intent(getActivity(), HomeActivity.class);
//        getActivity().startActivity(intent);

        textDate = view.findViewById(R.id.dates);
        datePicker = view.findViewById(R.id.datepicker);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDate.setText("Loading..");
                pickdate1();
                textDate.setText(textDate1 +  " - " + "Loading..");
                pickdate2();
                textDate.setText(textDate1 +  " - " + textDate2);
            }
        });

        roomPicker = view.findViewById(R.id.roompicker);
        roomPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent roomIntent = new Intent(getActivity(), RoomActivity.class);
                startActivity(roomIntent);
            }
        });

        searchButton = view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(getActivity(), SearchActivity.class);
                startActivity(searchIntent);
            }
        });
//
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        textDate = view.findViewById(R.id.dates);
//        datePicker = view.findViewById(R.id.datepicker);
//        datePicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textDate.setText("Loading..");
//                pickdate1();
//                textDate.setText(textDate1 +  " - " + "Loading..");
//                pickdate2();
//                textDate.setText(textDate1 +  " - " + textDate2);
//            }
//        });
//
//        roomPicker = view.findViewById(R.id.roompicker);
//        roomPicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        searchButton = view.findViewById(R.id.search_button);
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(getActivity(), SearchActivity.class);
//                startActivity(myIntent);
//            }
//        });
    }

    public void pickdate1(){
        final Calendar calendar1 = Calendar.getInstance();
        year1 = calendar1.get(Calendar.YEAR);
        month1 = calendar1.get(Calendar.MONTH);
        day1 = calendar1.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog picker1 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year1, int monthOfYear1, int dayOfMonth1) {
                if ((monthOfYear1 + 1) == 1){
                    textDate1 = dayOfMonth1 + " " + "Jan";
                }else if ((monthOfYear1 + 1) == 2){
                    textDate1 = dayOfMonth1 + " " + "Feb";
                }else if ((monthOfYear1 + 1) == 3){
                    textDate1 = dayOfMonth1 + " " + "Mar";
                }else if ((monthOfYear1 + 1) == 4){
                    textDate1 = dayOfMonth1 + " " + "Apr";
                }else if ((monthOfYear1 + 1) == 5){
                    textDate1 = dayOfMonth1 + " " + "May";
                }else if ((monthOfYear1 + 1) == 6){
                    textDate1 = dayOfMonth1 + " " + "Jun";
                }else if ((monthOfYear1 + 1) == 7){
                    textDate1 = dayOfMonth1 + " " + "Jul";
                }else if ((monthOfYear1 + 1) == 8){
                    textDate1 = dayOfMonth1 + " " + "Aug";
                }else if ((monthOfYear1 + 1) == 9){
                    textDate1 = dayOfMonth1 + " " + "Sep";
                }else if ((monthOfYear1 + 1) == 10){
                    textDate1 = dayOfMonth1 + " " + "Oct";
                }else if ((monthOfYear1 + 1) == 11){
                    textDate1 = dayOfMonth1 + " " + "Nov";
                }else{
                    textDate1 = dayOfMonth1 + " " + "Dec";
                }
            }
        }, year1, month1, day1);
        picker1.setCancelable(false);
        picker1.setTitle("Select the Check-In date");
        picker1.show();
    }

    public void pickdate2(){
        final Calendar calendar2 = Calendar.getInstance();
        year2 = calendar2.get(Calendar.YEAR);
        month2 = calendar2.get(Calendar.MONTH);
        day2 = calendar2.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog picker2 = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int monthOfYear2, int dayOfMonth2) {
                if ((monthOfYear2 + 1) == 1){
                    textDate2 = dayOfMonth2 + " " + "Jan";
                }else if ((monthOfYear2 + 1) == 2){
                    textDate2 = dayOfMonth2 + " " + "Feb";
                }else if ((monthOfYear2 + 1) == 3){
                    textDate2 = dayOfMonth2 + " " + "Mar";
                }else if ((monthOfYear2 + 1) == 4){
                    textDate2 = dayOfMonth2 + " " + "Apr";
                }else if ((monthOfYear2 + 1) == 5){
                    textDate2 = dayOfMonth2 + " " + "May";
                }else if ((monthOfYear2 + 1) == 6){
                    textDate2 = dayOfMonth2 + " " + "Jun";
                }else if ((monthOfYear2 + 1) == 7){
                    textDate2 = dayOfMonth2 + " " + "Jul";
                }else if ((monthOfYear2 + 1) == 8){
                    textDate2 = dayOfMonth2 + " " + "Aug";
                }else if ((monthOfYear2 + 1) == 9){
                    textDate2 = dayOfMonth2 + " " + "Sep";
                }else if ((monthOfYear2 + 1) == 10){
                    textDate2 = dayOfMonth2 + " " + "Oct";
                }else if ((monthOfYear2 + 1) == 11){
                    textDate2 = dayOfMonth2 + " " + "Nov";
                }else{
                    textDate2 = dayOfMonth2 + " " + "Dec";
                }
            }
        }, year2, month2, day2);
        picker2.setCancelable(false);
        picker2.setTitle("Select the Check-Out date");
        picker2.show();
    }
//
//    private DatePickerDialog.OnDateSetListener picker1Listener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                date1 = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
//            }
//        }, year1, month1, day1);
//        }
//    }

//    public static class HomeActivity extends AppCompatActivity {
//
//            LinearLayout datepicker;
//                TextView textdate;
//                TextView textroom;
//                String date1;
//                String date2;
//                int day1,month1,year1;
//                int day2,month2,year2;
//
//                @Override
//                protected void onCreate(Bundle savedInstanceState) {
//                    super.onCreate(savedInstanceState);
//                    setContentView(R.layout.fragment_home);
//                    datepicker = findViewById(R.id.datepicker);
//                    datepicker.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            pickdate1();
//                            pickdate2();
//                            textdate = findViewById(R.id.dates);
//                            textdate.setText(date1 +  "-" + date2);
//                        }
//                    });
//                }
//
//                public void pickdate1(){
//                    final Calendar calendar = Calendar.getInstance();
//                    year1 = calendar.get(Calendar.YEAR);
//                    month1 = calendar.get(Calendar.MONTH);
//                    day1 = calendar.get(Calendar.DAY_OF_MONTH);
//                    DatePickerDialog picker1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                            date1 = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
//                        }
//                    }, year1, month1, day1);
//                    picker1.setCancelable(false);
//                    picker1.setTitle("Select the Check-In date");
//                    picker1.show();
//                }
//
//                public void pickdate2(){
//                    final Calendar calendar = Calendar.getInstance();
//                    year2 = calendar.get(Calendar.YEAR);
//                    month2 = calendar.get(Calendar.MONTH);
//                    day2 = calendar.get(Calendar.DAY_OF_MONTH);
//                    DatePickerDialog picker2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                        @Override
//                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                            date2 = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
//                        }
//                    }, year2, month2, day2);
//                    picker2.setCancelable(false);
//                    picker2.setTitle("Select the Check-Out date");
//                    picker2.show();
//                }


//    }


}
