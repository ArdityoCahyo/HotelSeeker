package com.rplgdc.hotelseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Collections;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText NIM, Nama, Jurusan;
    private FirebaseAuth auth;
    private Button Logout, Simpan, Login, ShowData;

    private int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.authGoogle);
        Login.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() == null){
            redirect();
        }else{
            termredirect();
        }
    }


    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {

            if (resultCode == RESULT_OK) {
                Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                redirect();
            }else {
                Toast.makeText(LoginActivity.this, "Login Dibatalkan", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.authGoogle) {
            startActivityForResult(AuthUI.getInstance()
                            .createSignInIntentBuilder()

                            .setAvailableProviders(Collections.singletonList(new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .setIsSmartLockEnabled(false)
                            .build(),
                    RC_SIGN_IN);
        }
    }

    public void redirect(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void termredirect(){
        startActivity(new Intent(getApplicationContext(), TermPrivacyActivity.class));
        finish();
    }
}