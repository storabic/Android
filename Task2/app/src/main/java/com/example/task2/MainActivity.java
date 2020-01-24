package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView3);
        editText = (TextView)findViewById(R.id.editText);
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View viewObj) {
                if(editText.getText().length() > 100) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Важное сообщение!")
                            .setMessage("Длина текста не может быть больше 100")
                            .setCancelable(false).setNegativeButton()
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                textView.setText(editText.getText());
            }
        };
        button.setOnClickListener(onClick);
    }
}