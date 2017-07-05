package com.example.android.tourguideapp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Place {

    private String name;
    private String description;
    private String id;
    private Location location;

    public Place(JSONObject json) throws JSONException {
        setName(json.getString("name"));
        setId(json.getString("id"));
        setDescription(json.getString("description"));
        setLocation(new Location(json.getJSONObject("location")));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}