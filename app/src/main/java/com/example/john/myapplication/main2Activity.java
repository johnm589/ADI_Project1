package com.example.john.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();

        String stringOne = intent.getStringExtra("test");

        TextView tv = (TextView) findViewById(R.id.textView);

        tv.setText(stringOne);

    }
}
