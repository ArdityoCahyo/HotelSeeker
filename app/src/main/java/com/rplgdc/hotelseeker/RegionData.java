package com.rplgdc.hotelseeker;

public class RegionData {

    private String address;
    private String view;
    private String key;

    public RegionData(){}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public RegionData(String address, String view){
        this.address = address;
        this.view = view;
    }
}
