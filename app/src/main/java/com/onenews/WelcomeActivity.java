package com.onenews;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.onenews.activity.MyIntro;

import jonathanfinerty.once.Once;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        handler.postDelayed(runnable, 2000);
    }


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            finish();
            toActivity();
        }
    };

    private void toActivity() {
//        String showWhatsNew = "showMyIntroTag";
//        if (!Once.beenDone(Once.THIS_APP_VERSION, showWhatsNew)) {
//            Intent intent = new Intent(this, MyIntro.class);
//            startActivity(intent);
//            Once.markDone(showWhatsNew);
//        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
//        }
    }


}
