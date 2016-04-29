package com.example.daniel.wednesdaymaths;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LanguageSelectActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null)
            mp.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);

        // fonts
        Typeface luckyFont = Typeface.createFromAsset(getAssets(), "fonts/LuckiestGuy.ttf");

        TextView txLang1 = (TextView) findViewById(R.id.btnLang1);
        TextView txLang2 = (TextView) findViewById(R.id.btnLang2);
        TextView txLang3 = (TextView) findViewById(R.id.btnLang3);
        TextView txLang4 = (TextView) findViewById(R.id.btnLang4);
        txLang1.setTypeface(luckyFont);
        txLang2.setTypeface(luckyFont);
        txLang3.setTypeface(luckyFont);
        txLang4.setTypeface(luckyFont);

        Button btnLang1 = (Button) findViewById(R.id.btnLang1);
        btnLang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_hello);
                mp.start();

                setResult(MainActivity.LANG1_SELECTED);
                finish();
            }
        });

        Button btnLang2 = (Button) findViewById(R.id.btnLang2);
        btnLang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.lang2_hello);
                mp.start();

                setResult(MainActivity.LANG2_SELECTED);
                finish();
            }
        });

        Button btnLang3 = (Button) findViewById(R.id.btnLang3);
        btnLang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.lang3_hello);
                mp.start();

                setResult(MainActivity.LANG3_SELECTED);
                finish();
            }
        });

        Button btnLang4 = (Button) findViewById(R.id.btnLang4);
        btnLang4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.lang4_hello);
                mp.start();

                setResult(MainActivity.LANG4_SELECTED);
                finish();
            }
        });

    }
}
