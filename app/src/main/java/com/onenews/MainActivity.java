package com.onenews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.onenews.activity.BaseActivity;
import com.onenews.activity.CityActivity;
import com.onenews.activity.ClassifyActivity;
import com.onenews.utils.L;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getCitys = (Button) findViewById(R.id.getCitys);
        getCitys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivityForResult(intent, 333);
            }
        });

        Button getClassify = (Button) findViewById(R.id.getClassify);


        getClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClassifyActivity.class);
                startActivityForResult(intent, 333);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 333) {


            String cityID = data.getStringExtra("cityID");
            String cityName = data.getStringExtra("cityName");
            String cityPinyin = data.getStringExtra("cityPinyin");
            String cityShortName = data.getStringExtra("cityShortName");
            String cityShortPinyin = data.getStringExtra("cityShortPinyin");

            L.e("" + cityID + cityName);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }




}
