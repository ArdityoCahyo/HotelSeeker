package com.rplgdc.hotelseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity {

    private static final int min = 1;
    private static final int max = 4;
    private LinearLayout sumLayout;
    private Button roomPlus;
    private Button roomMin;

    public int sumRoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        sumLayout = (LinearLayout) findViewById(R.id.sum);

        setTitle("Rooms and Guests");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView textSum = (TextView) findViewById(R.id.sumRooms);
        sumRoom = Integer.parseInt(textSum.getText().toString());

        if (sumRoom == min){
            roomMin = (Button) findViewById(R.id.roomMin);
            roomMin.setEnabled(false);
            
        }

        roomPlus = (Button) findViewById(R.id.roomPlus);
        roomPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumRoom += 1;
                if (sumRoom < max){
                    for(int i = 1; i <= sumRoom; i++){
//                        LinearLayout roomCard = (LinearLayout) LayoutInflater.from(RoomActivity.this).inflate(R.layout.content_card_room, null);
//                        view = (View) LayoutInflater.from(RoomActivity.this).inflate(R.layout.content_card_room, null);
//                        TextView roomNumber = (TextView) findViewById(R.id.roomNum);
//
//                        roomNumber.setText("Room " + i);
//                        sumLayout.addView(roomCard);

                        Toast.makeText(RoomActivity.this, "Kurang +"+ i , Toast.LENGTH_SHORT).show();
                    }
                    roomPlus.setEnabled(true);
                    roomMin.setEnabled(true);
                }else{
                    sumRoom = max;
                    roomPlus.setEnabled(false);
                    Toast.makeText(RoomActivity.this, "Lebih +", Toast.LENGTH_SHORT).show();
                }
                textSum.setText(String.valueOf(sumRoom));
            }
        });

        roomMin = (Button) findViewById(R.id.roomMin);
        roomMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumRoom -= 1;
                if (sumRoom > min){
                    for(int i = 1; i < sumRoom; i++){
                        Toast.makeText(RoomActivity.this, "Kurang -", Toast.LENGTH_SHORT).show();
                    }
                    roomPlus.setEnabled(true);
                    roomMin.setEnabled(true);
                }else{
                    sumRoom = min;
                    roomMin.setEnabled(false);
                    Toast.makeText(RoomActivity.this, "Lebih -", Toast.LENGTH_SHORT).show();
                }
                textSum.setText(String.valueOf(sumRoom));
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
}