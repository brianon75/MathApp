package com.example.daniel.wednesdaymaths;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // fonts
        Typeface luckyFont = Typeface.createFromAsset(getAssets(), "fonts/LuckiestGuy.ttf");

        // grab the arraylist with all the answered questions
        ArrayList<Question> myListCheck = (ArrayList<Question>) getIntent().getSerializableExtra("questionList");

        // need to track the number of correct answers
        int numCorrect = 0;

        // find the next unanswered question
        for (int i = 0; i < myListCheck.size(); i++) {
            if (myListCheck.get(i).getIsCorrect()) {
                numCorrect++;
            }

            // each button needs to have it's colour altered based on the result
            Button btn = (Button) findViewById(R.id.btnResult1+i);
            btn.setBackgroundColor(myListCheck.get(i).getIsCorrect() ? Color.rgb(156, 39, 176) : Color.rgb(181,140,189));
            btn.setTypeface(luckyFont);
        }

        // get the texview for displaying the result
        TextView txResult = (TextView) findViewById(R.id.result);
        txResult.setTypeface(luckyFont);
        txResult.setText(numCorrect + "");

        Button btnCorrect = (Button) findViewById(R.id.btnCorrect);
        btnCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
