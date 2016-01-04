package com.onenews.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.onenews.MainActivity;
import com.onenews.R;
import com.onenews.fragment.SampleSlide;

/**
 * Created by yangweidong on 15/12/30.
 */
public class MyIntro extends AppIntro {
    // Please DO NOT override onCreate. Use init.
    @Override
    public void init(Bundle savedInstanceState) {
// Add your slide's fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));
        setDepthAnimation();
    }

    private void loadMainActivity() {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onSkipPressed() {
        loadMainActivity();
        // Do something when users tap on Skip button.
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        loadMainActivity();
    }

    @Override
    public void onSlideChanged() {

    }
}
