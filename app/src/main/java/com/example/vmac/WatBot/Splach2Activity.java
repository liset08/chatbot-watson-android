package com.example.vmac.WatBot;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splach2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach2);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splach2Activity.this, LoginActivity.class));
            }
        }, 3000);
    }

}

