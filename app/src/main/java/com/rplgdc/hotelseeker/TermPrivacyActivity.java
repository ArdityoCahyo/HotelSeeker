package com.rplgdc.hotelseeker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.rplgdc.hotelseeker.SplashScreenActivity.SHARED_PREFS;
import static com.rplgdc.hotelseeker.SplashScreenActivity.status;

public class TermPrivacyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        Button agree = (Button) findViewById(R.id.agree);

        TextView cek = (TextView) findViewById(R.id.cek);
        cek.setText(loadData());

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
    }

    public String loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        String loadStatus = sharedPreferences.getString(status, "");
        return loadStatus;
    }
}

