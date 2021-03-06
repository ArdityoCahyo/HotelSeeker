package com.rplgdc.hotelseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    private String loadStatus;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String status = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(getApplicationContext(), TermPrivacyActivity.class));
//                finish();
                if(CheckNetwork.isInternetAvailable(SplashScreenActivity.this)) //returns true if internet available
                {
                    if (loadData().contains("agreed")){
                        redirect();
                    }else{
                        saveData();
                        termredirect();
                    }
                }
                else
                {
                    noInternet();
                    Toast.makeText(SplashScreenActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000L);
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(status, "agreed");
        editor.apply();
    }

    private String loadData(){
        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        loadStatus = sharedPreferences.getString(status, "");
        return loadStatus;
    }

    private void redirect(){
        startActivity(new Intent(getApplicationContext(), OnBoardActivity.class)); //Status redirect temporary
        finish();
    }

    private void termredirect(){
        startActivity(new Intent(getApplicationContext(), OnBoardActivity.class)); //Status redirect temporary
        finish();
    }

    private void noInternet(){
        startActivity(new Intent(getApplicationContext(), NoInternetActivity.class)); //Status redirect temporary
        finish();
    }
}
