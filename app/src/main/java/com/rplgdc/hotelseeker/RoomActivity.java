package com.rplgdc.hotelseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
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
    private Button guestPlus;
    private Button guestMin;

    public int sumRoom;
    public int sumGuest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

//        sumLayout = (LinearLayout) findViewById(R.id.sum);

        setTitle("Rooms and Guests");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView textSumRoom = (TextView) findViewById(R.id.sumRooms);
        final TextView textSumGuest = (TextView) findViewById(R.id.sumGuests);

        roomPlus = (Button) findViewById(R.id.roomPlus);
        roomMin = (Button) findViewById(R.id.roomMin);
        guestPlus = (Button) findViewById(R.id.guestsPlus);
        guestMin = (Button) findViewById(R.id.guestsMin);

        sumRoom = Integer.parseInt(textSumRoom.getText().toString());
        sumGuest = Integer.parseInt(textSumGuest.getText().toString());

        if (sumRoom == min){
            roomMin = (Button) findViewById(R.id.roomMin);
            roomMin.setEnabled(false);
            guestMin = (Button) findViewById(R.id.guestsMin);
            guestMin.setEnabled(false);
        }

        TypedValue typedValueRoom = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValueRoom, true);
        final int colorPrimary = typedValueRoom.data;

        Drawable buttonDrawableRoom = roomPlus.getBackground();
        buttonDrawableRoom = DrawableCompat.wrap(buttonDrawableRoom);
        DrawableCompat.setTint(buttonDrawableRoom, colorPrimary);
        roomPlus.setBackground(buttonDrawableRoom);

        Drawable buttonDrawableGuests = guestPlus.getBackground();
        buttonDrawableGuests = DrawableCompat.wrap(buttonDrawableGuests);
        DrawableCompat.setTint(buttonDrawableGuests, colorPrimary);
        guestPlus.setBackground(buttonDrawableGuests);


        roomPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumRoom += 1;
                if (sumRoom < max){
                    for(int i = 1; i <= sumRoom; i++){
//                        LinearLayout roomCard = (LinearLayout) LayoutInflater.from(RoomActivity.this).inflate(R.layout.content_card_room, null);
//                        roomCard.removeAllViews();
//                        view = (View) LayoutInflater.from(RoomActivity.this).inflate(R.layout.content_card_room, null);
//                        TextView roomNumber = (TextView) findViewById(R.id.roomNum);
//
//                        roomNumber.setText("Room " + i);
//                        sumLayout.addView(roomCard);

//                        Toast.makeText(RoomActivity.this, "Kurang +"+ i , Toast.LENGTH_SHORT).show();
                    }
                    roomPlus.setEnabled(true);
                    roomMin.setEnabled(true);
                }else{
                    sumRoom = max;
                    roomPlus.setEnabled(false);
                    Drawable buttonDrawableRoom = roomPlus.getBackground();
                    buttonDrawableRoom = DrawableCompat.wrap(buttonDrawableRoom);
                    DrawableCompat.setTint(buttonDrawableRoom, Color.LTGRAY);
                    roomPlus.setBackground(buttonDrawableRoom);
//                    Toast.makeText(RoomActivity.this, "Lebih +", Toast.LENGTH_SHORT).show();
                }
                textSumRoom.setText(String.valueOf(sumRoom));
            }
        });

        roomMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumRoom -= 1;
                Drawable buttonDrawable = roomPlus.getBackground();
                buttonDrawable = DrawableCompat.wrap(buttonDrawable);
                DrawableCompat.setTint(buttonDrawable, colorPrimary);
                roomPlus.setBackground(buttonDrawable);
                if (sumRoom > min){
                    for(int i = 1; i < sumRoom; i++){
//                        Toast.makeText(RoomActivity.this, "Kurang -", Toast.LENGTH_SHORT).show();
                    }
                    roomPlus.setEnabled(true);
                    roomMin.setEnabled(true);
                }else{
                    sumRoom = min;
                    roomMin.setEnabled(false);
//                    Toast.makeText(RoomActivity.this, "Lebih -", Toast.LENGTH_SHORT).show();
                }
                textSumRoom.setText(String.valueOf(sumRoom));
            }
        });

        guestPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumGuest += 1;
                if (sumGuest < max){
                    for(int i = 1; i <= sumGuest; i++){
//                        LinearLayout roomCard = (LinearLayout) LayoutInflater.from(RoomActivity.this).inflate(R.layout.content_card_room, null);
//                        roomCard.removeAllViews();
//                        view = (View) LayoutInflater.from(RoomActivity.this).inflate(R.layout.content_card_room, null);
//                        TextView roomNumber = (TextView) findViewById(R.id.roomNum);
//
//                        roomNumber.setText("Room " + i);
//                        sumLayout.addView(roomCard);

//                        Toast.makeText(RoomActivity.this, "Kurang +"+ i , Toast.LENGTH_SHORT).show();
                    }
                    guestPlus.setEnabled(true);
                    guestMin.setEnabled(true);
                }else{
                    sumGuest = max;
                    guestPlus.setEnabled(false);
                    Drawable buttonDrawableGuests = guestPlus.getBackground();
                    buttonDrawableGuests = DrawableCompat.wrap(buttonDrawableGuests);
                    DrawableCompat.setTint(buttonDrawableGuests, Color.LTGRAY);
                    guestPlus.setBackground(buttonDrawableGuests);
//                    Toast.makeText(RoomActivity.this, "Lebih +", Toast.LENGTH_SHORT).show();
                }
                textSumGuest.setText(String.valueOf(sumGuest));
            }
        });

        guestMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumGuest -= 1;
                Drawable buttonDrawableGuests = guestPlus.getBackground();
                buttonDrawableGuests = DrawableCompat.wrap(buttonDrawableGuests);
                DrawableCompat.setTint(buttonDrawableGuests, colorPrimary);
                guestPlus.setBackground(buttonDrawableGuests);
                if (sumGuest > min){
                    for(int i = 1; i < sumRoom; i++){
//                        Toast.makeText(RoomActivity.this, "Kurang -", Toast.LENGTH_SHORT).show();
                    }
                    guestPlus.setEnabled(true);
                    guestMin.setEnabled(true);
                }else{
                    sumGuest = min;
                    guestMin.setEnabled(false);
//                    Toast.makeText(RoomActivity.this, "Lebih -", Toast.LENGTH_SHORT).show();
                }
                textSumGuest.setText(String.valueOf(sumGuest));
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