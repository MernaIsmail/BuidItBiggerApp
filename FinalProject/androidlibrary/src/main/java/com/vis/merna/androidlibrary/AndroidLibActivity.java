package com.vis.merna.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AndroidLibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_lib);
        TextView textView = findViewById(R.id.joke_textView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            textView.setText(extras.getString(Intent.EXTRA_TEXT));
        }
    }
}
