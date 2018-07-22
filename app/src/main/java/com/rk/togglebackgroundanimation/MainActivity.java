package com.rk.togglebackgroundanimation;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FrameLayout layoutLock = (FrameLayout) findViewById(R.id.layout_lock);
        final ImageView imgUnlLock = (ImageView) findViewById(R.id.img_unlock);
        final ImageView imgLock = (ImageView) findViewById(R.id.img_lock);
        final TextView txtDoorStatus = (TextView) findViewById(R.id.txt_door_status);

        imgUnlLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator anim = ObjectAnimator.ofFloat(layoutLock,"x",867);
                anim.setDuration(1000); // duration 5 seconds
                anim.start();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        imgUnlLock.setImageResource(R.mipmap.unlock_enable);
                        imgLock.setImageResource(R.mipmap.lock_disable);
                        txtDoorStatus.setText(getString(R.string.unlock));

                    }
                }, 700);
            }
        });

        imgLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator anim = ObjectAnimator.ofFloat(layoutLock,"x",12);
                anim.setDuration(1000); // duration 5 seconds
                anim.start();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        imgUnlLock.setImageResource(R.mipmap.unlock_disable);
                        imgLock.setImageResource(R.mipmap.locked);
                        txtDoorStatus.setText(getString(R.string.locked));
                    }
                }, 700);

            }
        });
    }
}
