package com.busycount.keyboard.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.busycount.keyboard.NumKeyboard;
import com.busycount.keyboard.OnNumKeyListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumKeyboard keyboard = findViewById(R.id.numKeyboard);
        keyboard.setOnNumKeyListener(new OnNumKeyListener() {
            @Override
            public void onKeyNum(char num) {
                show("" + num);
            }

            @Override
            public void onKeyDelete() {
                show("key delete");
            }

            @Override
            public void onKeyDone() {
                show("key done");
            }
        });
    }

    private void show(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}

