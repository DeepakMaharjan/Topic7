package com.deepak.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddMessageActivity extends AppCompatActivity {

    private EditText etWord, etMeaning;
    private Button btnAddNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddNow = findViewById(R.id.btnAddNow);

        btnAddNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE|MODE_APPEND));
            printStream.println(etWord.getText().toString()+ " -> " + etMeaning.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("Dictionary app", "Error: " + e.toString());
            e.printStackTrace();
        }
    }
}

