package com.example.daniel.wednesdaymaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        // retrieve the operator
        Bundle b = getIntent().getExtras();
        final int opSelected = b.getInt("key");

        //Toast.makeText(this, "this is my Toast message!!! =)",                Toast.LENGTH_LONG).show();
        // generate our questions




        Button btnLevel1 = (Button) findViewById(R.id.btnLevel1);
        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList alQuestions = new ArrayList<Question>(9);


                for (int i = 0; i < 9; i++) {
                    alQuestions.add(new Question(opSelected, 1));
                }

                Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                intent.putExtra("questionList", alQuestions);
                startActivity(intent);

            }
        });

        Button btnLevel2 = (Button) findViewById(R.id.btnLevel2);
        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList alQuestions = new ArrayList<Question>(9);

                for (int i = 0; i < 9; i++) {
                    alQuestions.add(new Question(opSelected, 2));
                }

                Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                intent.putExtra("questionList", alQuestions);
                startActivity(intent);
            }
        });


        Button btnLevel3 = (Button) findViewById(R.id.btnLevel3);
        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList alQuestions = new ArrayList<Question>(9);

                for (int i = 0; i < 9; i++) {
                    alQuestions.add(new Question(opSelected, 3));
                }

                Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                intent.putExtra("questionList", alQuestions);
                startActivity(intent);
            }
        });

        Button btnLevel4 = (Button) findViewById(R.id.btnLevel4);
        btnLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList alQuestions = new ArrayList<Question>(9);

                for (int i = 0; i < 9; i++) {
                    alQuestions.add(new Question(opSelected, 4));
                }

                Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                intent.putExtra("questionList", alQuestions);
                startActivity(intent);
            }
        });

        Button btnLevel5 = (Button) findViewById(R.id.btnLevel5);
        btnLevel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList alQuestions = new ArrayList<Question>(9);

                for (int i = 0; i < 9; i++) {
                    alQuestions.add(new Question(opSelected, 5));
                }

                Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                intent.putExtra("questionList", alQuestions);
                startActivity(intent);
            }
        });

    }
}
