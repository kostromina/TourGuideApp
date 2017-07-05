package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.tourguideapp.helpers.Constants;
import com.example.android.tourguideapp.models.Place;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private String mCategory;
    private ArrayList<Place> mPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Bundle bundle = getIntent().getExtras();
        mPlaces = new ArrayList<>();

        if(bundle != null) {
            mCategory = bundle.getString(Constants.CATEGORY_PARAMETER_NAME);
            loadCategory();
        }

    }

    private void loadCategory() {
        JSONArray placesData = loadPlacesJsonData();
        assert placesData != null;
        try {
            buildPlacesList(placesData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("TAG", placesData.toString());
    }

    private void buildPlacesList(JSONArray placesData) throws JSONException {
        int placesSize = placesData.length();
        for(int i = 0; i < placesSize; i++) {
            mPlaces.add(new Place(placesData.getJSONObject(i)));
        }
    }

    private JSONArray loadPlacesJsonData() {
        try {
            InputStream is = getAssets().open(mCategory+".json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            return new JSONArray(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
