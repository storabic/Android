package com.example.task6_animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private Button b;
    private boolean lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lock = true;
        b = findViewById(R.id.button);
        b.setMinWidth(50);
        b.setMinHeight(50);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation =
                        AnimationUtils.loadAnimation(MainActivity.this,
                                R.anim.anim);
                button.startAnimation(animation);

            }
        });
    }

    public void changeButtonSize(android.view.View v) {
        b.setWidth(lock?100:200);
        b.setHeight(lock?50:100);
        lock = !lock;
    }
}
