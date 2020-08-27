package com.rplgdc.hotelseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegionActivity extends AppCompatActivity {

    private RecyclerView regionView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private DatabaseReference reference;
    private ArrayList<RegionData> dataRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        setTitle("Destination");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        regionView = findViewById(R.id.region_list);
        RegionRecyclerView();
        GetData();
    }

    private void GetData(){
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("region")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataRegion = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                            RegionData region_list = snapshot.getValue(RegionData.class);

                            region_list.setKey(snapshot.getKey());
                            dataRegion.add(region_list);
                        }

                        adapter = new RegionViewAdapter(dataRegion, RegionActivity.this);

                        regionView.setAdapter(adapter);

                        Toast.makeText(getApplicationContext(),"Data Berhasil Dimuat", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(getApplicationContext(),"Data Gagal Dimuat", Toast.LENGTH_LONG).show();
                        Log.e("RegionActivity", databaseError.getDetails()+" "+databaseError.getMessage());
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void RegionRecyclerView(){
        layoutManager = new LinearLayoutManager(this);
        regionView.setLayoutManager(layoutManager);
        regionView.setHasFixedSize(true);
    }
}