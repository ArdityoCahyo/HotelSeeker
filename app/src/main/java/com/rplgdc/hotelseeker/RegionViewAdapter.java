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

public class RegionViewAdapter extends RecyclerView.Adapter<RegionViewAdapter.ViewHolder>{
    private ArrayList<RegionData> listRegion;
    private Context context;

    public RegionViewAdapter(ArrayList<RegionData> listRegion, Context context) {
        this.listRegion = listRegion;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nameRegion;
        private LinearLayout ListRegionItem;

        ViewHolder(View itemView) {
            super(itemView);
            nameRegion = itemView.findViewById(R.id.nameRegion);
            ListRegionItem = itemView.findViewById(R.id.list_item);
        }
    }


    @Override
    public RegionViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_list_region, parent, false);
        return new RegionViewAdapter.ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RegionViewAdapter.ViewHolder holder, final int position) {
        final String nameRegion = listRegion.get(position).getView();

        holder.nameRegion.setText(""+nameRegion);

//        holder.ListRegionItem.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                return false;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listRegion.size();
    }

}
