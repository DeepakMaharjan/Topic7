package com.deepak.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Meaning extends AppCompatActivity {

    TextView tvMeanings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);


        tvMeanings = findViewById(R.id.tvMeaning);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String meaning = bundle.getString("meaning");
            tvMeanings.setText(meaning);
        }
    }
}
