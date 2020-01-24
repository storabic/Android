package com.example.task3;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class activity1 extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (TextView) findViewById(R.id.editText);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent a = new Intent(this, activity2.class);
        a.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        a.putExtra("text", editText.getText().toString());
        startActivity(a);
    }
}
