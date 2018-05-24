package com.example.vmac.WatBot.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vmac.WatBot.R;

public class Splach2Activity extends AppCompatActivity {
    private TextView name;
    private TextView name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach2);

        name = (TextView) findViewById(R.id.textView3);
        name2 = (TextView) findViewById(R.id.textView2);

        Typeface face2=Typeface.createFromAsset(getAssets(),"Narcissus.ttf");
        name2.setTypeface(face2);

        Typeface face=Typeface.createFromAsset(getAssets(),"Narcissus.ttf");
        name.setTypeface(face);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splach2Activity.this, LoginActivity.class));
            }
        }, 3000);


    }

}

