package com.rplgdc.hotelseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class OnBoardActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    ProgressDialog progressDialog;
    private Button googleButton;
    private Button facebookButton;
    private Button emailButtom;
    private GoogleSignInOptions GSO;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private final int RC_SIGN_ID = 9001;
    private final String TAG = "SignInAcivity";
    private FirebaseUser user;
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        googleButton = findViewById(R.id.googleAuth);
        facebookButton = findViewById(R.id.facebookAuth);
        emailButtom = findViewById(R.id.emailAuth);

        FirebaseConnect();
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, null);
                SignIn();
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Facebook Auth Comingsoon!", Toast.LENGTH_SHORT).show();
            }
        });

        emailButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectLogin();
            }
        });
    }

    private void FirebaseConnect(){
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if(user != null){
                    startActivity(new Intent(OnBoardActivity.this,MainActivity.class));
                    finish();
                }
            }
        };

        GSO = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, GSO)
                .build();
    }

    private void SignIn(){
        Intent GSignIN = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(GSignIN, RC_SIGN_ID);
        progressDialog.setMessage("Mohon Tunggu...");
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account){
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(OnBoardActivity.this,MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"Autentikasi Gagal", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "OnConnectionFailed" + connectionResult);
        progressDialog.dismiss();
        Toast.makeText(getApplicationContext(),"Koneksi Gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener != null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_ID) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }else {
                progressDialog.dismiss();
            }
        }else{
            progressDialog.dismiss();
        }
    }

    private void redirectLogin(){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}