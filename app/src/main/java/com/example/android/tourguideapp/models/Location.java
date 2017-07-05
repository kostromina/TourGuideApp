package com.example.android.tourguideapp.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by oxanakostromina on 05/07/2017.
 */
public class Location {

    private double lon;
    private double lat;

    public Location(JSONObject json) throws JSONException {
        setLat(json.getDouble("lat"));
        setLon(json.getDouble("lon"));
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

}