package com.example.daniel.wednesdaymaths;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int PICK_LANGUAGE_REQUEST = 1;  // The request code
    static final int LANG_OFFSET = 108; // # sound files for each language ****must be the same
    static final int LANG1_SELECTED = 0;
    static final int LANG2_SELECTED = LANG1_SELECTED + LANG_OFFSET;
    static final int LANG3_SELECTED = LANG2_SELECTED + LANG_OFFSET;
    static final int LANG4_SELECTED = LANG3_SELECTED + LANG_OFFSET;
    static final int LANG5_SELECTED = LANG4_SELECTED + LANG_OFFSET;

    static final int OPERATOR_ADD = 1;
    static final int OPERATOR_SUB = 2;
    static final int OPERATOR_MUL = 3;
    static final int OPERATOR_DIV = 4;

    //  R.raw.<resid> is an int. Use offset to move through languages
    public static int languageOffset = 0; // 4
    MediaPlayer mp;

    @Override
    public void onRestart()
    {
        super.onRestart();
        TextView txLang = (TextView) findViewById(R.id.btnLanguageSelect);
        String strLang = "";

        if (languageOffset == LANG1_SELECTED) {
            txLang.setText("English");
        } else if (languageOffset == LANG2_SELECTED) {
            txLang.setText("German");
        } else if (languageOffset == LANG3_SELECTED) {
        txLang.setText("French");
        } else if (languageOffset == LANG4_SELECTED) {
            txLang.setText("Irish");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fonts
        Typeface luckyFont = Typeface.createFromAsset(getAssets(), "fonts/LuckiestGuy.ttf");

        TextView txCounting = (TextView) findViewById(R.id.countingBanner);
        TextView txAdd = (TextView) findViewById(R.id.btnAddition);
        TextView txSub = (TextView) findViewById(R.id.btnSubtraction);
        TextView txMul = (TextView) findViewById(R.id.btnMultiplication);
        TextView txDiv = (TextView) findViewById(R.id.btnDivision);
        TextView txLang = (TextView) findViewById(R.id.btnLanguageSelect);
        txCounting.setTypeface(luckyFont);
        txAdd.setTypeface(luckyFont);
        txSub.setTypeface(luckyFont);
        txMul.setTypeface(luckyFont);
        txDiv.setTypeface(luckyFont);
        txLang.setTypeface(luckyFont);
        if (languageOffset == LANG1_SELECTED) {
            txLang.setText("English");
        } else if (languageOffset == LANG2_SELECTED) {
            txLang.setText("German");
        } else if (languageOffset == LANG3_SELECTED) {
            txLang.setText("French");
        } else if (languageOffset == LANG4_SELECTED) {
            txLang.setText("Irish");
        }



        Button btnAddition = (Button) findViewById(R.id.btnAddition);
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_add + languageOffset);
                mp.start();

                Bundle b = new Bundle();
                b.putInt("key", OPERATOR_ADD); // Our operator

                Intent intent = new Intent(v.getContext(), DifficultyActivity.class);
                intent.putExtras(b);

                startActivity(intent);

            }
        });

        Button btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_subtract+languageOffset);
                mp.start();

                Bundle b = new Bundle();
                b.putInt("key", OPERATOR_SUB); // Our operator

                Intent intent = new Intent(v.getContext(),DifficultyActivity.class);
                intent.putExtras(b);

                startActivity(intent);
            }
        });

        Button btnMulitplication = (Button) findViewById(R.id.btnMultiplication);
        btnMulitplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_multiply+languageOffset);
                mp.start();

                Bundle b = new Bundle();
                b.putInt("key", OPERATOR_MUL); // Our operator

                Intent intent = new Intent(v.getContext(),DifficultyActivity.class);
                intent.putExtras(b);

                startActivity(intent);
            }
        });

        Button btnDivision = (Button) findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_divide+languageOffset);
                mp.start();

                Bundle b = new Bundle();
                b.putInt("key", OPERATOR_DIV); // Our operator

                Intent intent = new Intent(v.getContext(),DifficultyActivity.class);
                intent.putExtras(b);

                startActivity(intent);
            }
        });

        Button btnLanguageSelect = (Button) findViewById(R.id.btnLanguageSelect);
        btnLanguageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),LanguageSelectActivity.class);
                startActivityForResult(intent, PICK_LANGUAGE_REQUEST);

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null)
            mp.release();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check which request we're responding to
        if (requestCode == PICK_LANGUAGE_REQUEST) {

            // set the language based on the return result
            languageOffset = resultCode;

        }
    }
}
