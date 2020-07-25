package com.rplgdc.hotelseeker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    private ArrayList<HotelData> listHotel;
    private Context context;

    public RecyclerViewAdapter(ArrayList<HotelData> listHotel, Context context) {
        this.listHotel = listHotel;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Name, Region,Rate,Room,PriceHotel,PriceHotelDisc,Disc,Disc2;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.nameHotel);
            Region = itemView.findViewById(R.id.regionHotel);
            Rate = itemView.findViewById(R.id.rateHotel);
            Room = itemView.findViewById(R.id.roomHotel);
            PriceHotel = itemView.findViewById(R.id.priceHotel);
            PriceHotelDisc = itemView.findViewById(R.id.priceHotelDisc);
            Disc = itemView.findViewById(R.id.disc);
            Disc2 = itemView.findViewById(R.id.disc2);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_card_hotel, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String Name = listHotel.get(position).getNameHotel();
        final String Region = listHotel.get(position).getRegionHotel();
        final int Rate = listHotel.get(position).getRateHotel();
        final int Room = listHotel.get(position).getRoomHotel();
        final int PriceHotel = listHotel.get(position).getPriceHotel();
        final int PriceHotelDisc = listHotel.get(position).getPriceHotelDisc();

        holder.Name.setText(""+Name);
        holder.Region.setText(""+Region);
        holder.Rate.setText(""+Rate);
        holder.Room.setText(""+Room);
        holder.PriceHotel.setText(""+PriceHotel);
        holder.PriceHotelDisc.setText(""+PriceHotelDisc);
        holder.Disc.setText(""+DiscCalc(PriceHotel,PriceHotelDisc));
        holder.Disc2.setText(""+DiscCalc(PriceHotel,PriceHotelDisc));

//        holder.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                return true;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    public int DiscCalc(int PriceHotel, int PriceHotelDisc){
        int p1 = PriceHotel;
        int p2 = PriceHotelDisc;
        int Total = (p1/p2) * 100;
        return Total;
    }

}


