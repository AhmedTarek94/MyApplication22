package com.example.ltc_pc.myapplication;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class activity_splash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

              //  ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,res.transition.);



                Intent i = new Intent(activity_splash.this, MainActivity.class);
                activity_splash.this.startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                activity_splash.this.finish();
                startActivity(i);
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());

    }

}