package com.rplgdc.hotelseeker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private DatabaseReference reference;
    private ArrayList<HotelData> dataHotel;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.content_search);
        recyclerView = findViewById(R.id.hotel_list);
        auth = FirebaseAuth.getInstance();
        MyRecyclerView();
        GetData();

        TextView des = findViewById(R.id.destination_button);
        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectHotelInfo();
            }
        });
    }

    private void GetData(){
//        Toast.makeText(getApplicationContext(),"Mohon Tunggu Sebentar...", Toast.LENGTH_LONG).show();
        reference = FirebaseDatabase.getInstance().getReference();
//        reference.child("hotel").child(auth.getUid()).child("bandung")
        reference.child("hotel").child("x8Jset2TiEWbzWnDJwls")
//        reference.child("hotel")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataHotel = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                            HotelData hotel_list = snapshot.getValue(HotelData.class);

                            hotel_list.setKey(snapshot.getKey());
                            dataHotel.add(hotel_list);
                        }

                        adapter = new RecyclerViewAdapter(dataHotel, SearchActivity.this);

                        recyclerView.setAdapter(adapter);

                        Toast.makeText(getApplicationContext(),"Data Berhasil Dimuat", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(getApplicationContext(),"Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                        Log.e("SearchActivity", databaseError.getDetails()+" "+databaseError.getMessage());
                    }
                });
    }

    private void MyRecyclerView(){
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void redirectHotelInfo(){
        startActivity(new Intent(getApplicationContext(), HotelInfoActivity.class));
        finish();
    }
}
