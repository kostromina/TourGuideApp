package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.tourguideapp.helpers.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.category_outdoors).setOnClickListener(this);
        findViewById(R.id.category_city_sights).setOnClickListener(this);
        findViewById(R.id.category_museums).setOnClickListener(this);
        findViewById(R.id.category_food).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category_food: openCategoryActivity(Constants.CATEGORY_FOOD); break;
            case R.id.category_city_sights: openCategoryActivity(Constants.CATEGORY_CITY_SIGHTS); break;
            case R.id.category_museums: openCategoryActivity(Constants.CATEGORY_MUSEUMS); break;
            case R.id.category_outdoors: openCategoryActivity(Constants.CATEGORY_OUTDOORS); break;
        }
    }

    private void openCategoryActivity(String category){
        Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
        intent.putExtra(Constants.CATEGORY_PARAMETER_NAME, category);
        startActivity(intent);
    }


}
