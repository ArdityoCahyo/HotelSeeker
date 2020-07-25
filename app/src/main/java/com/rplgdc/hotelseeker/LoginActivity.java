package com.rplgdc.hotelseeker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;


public class LoginActivity extends AppCompatActivity {

    private TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerText = findViewById(R.id.registerText);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectRegister();
            }
        });
    }

    private void redirectRegister(){
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        finish();
    }

}