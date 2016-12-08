package com.androidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class JokeActivityLib extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_lib);

        TextView textView= (TextView) findViewById(R.id.textview_joke);
        textView.setText(getIntent().getStringExtra("joke"));
    }
}
