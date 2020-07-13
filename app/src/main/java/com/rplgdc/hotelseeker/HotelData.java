package com.rplgdc.hotelseeker;

import com.google.firebase.auth.FirebaseAuth;

public class HotelData {

    private String nameHotel;
    private String regionHotel;
    private int rateHotel;
    private int roomHotel;
    private int priceHotel;
    private int priceHotelDisc;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getRegionHotel() {
        return regionHotel;
    }

    public void setRegionHotel(String regionHotel) {
        this.regionHotel = regionHotel;
    }

    public int getRateHotel() {
        return rateHotel;
    }

    public void setRateHotel(int rateHotel) {
        this.rateHotel = rateHotel;
    }

    public int getRoomHotel() {
        return roomHotel;
    }

    public void setRoomHotel(int roomHotel) {
        this.roomHotel = roomHotel;
    }

    public int getPriceHotel() {
        return priceHotel;
    }

    public void setPriceHotel(int priceHotel) {
        this.priceHotel = priceHotel;
    }

    public int getPriceHotelDisc() {
        return priceHotelDisc;
    }

    public void setPriceHotelDisc(int priceHotelDisc) {
        this.priceHotelDisc = priceHotelDisc;
    }

    public HotelData(){
    }

    public HotelData(String nameHotel, String regionHotel, int rateHotel, int roomHotel, int priceHotel, int priceHotelDisc) {
        this.nameHotel = nameHotel;
        this.regionHotel = regionHotel;
        this.rateHotel = rateHotel;
        this.roomHotel = roomHotel;
        this.priceHotel = priceHotel;
        this.priceHotelDisc = priceHotelDisc;
    }

}
