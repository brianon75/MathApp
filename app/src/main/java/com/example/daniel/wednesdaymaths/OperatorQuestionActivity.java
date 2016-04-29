package com.example.daniel.wednesdaymaths;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OperatorQuestionActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_operator_question);

        final MediaPlayer mpC = MediaPlayer.create(getApplicationContext(), R.raw.lang1_correct + MainActivity.languageOffset);

        ArrayList<Question> myListCheck = (ArrayList<Question>) getIntent().getSerializableExtra("questionList");
        int nextQuestion = 0;
        // find the next unanswered question
        for (int i = 0; i < myListCheck.size(); i++) {
            if (!myListCheck.get(i).getIsAnswered()) {
                nextQuestion = i;
                break;
            }
        }


        Question q = myListCheck.get(nextQuestion);

        TextView t = (TextView) findViewById(R.id.tvQuestion);
        t.setText(q.toString());

        int [] answers = q.getAnswers();
        Button btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer1.setText(answers[0] + "");
        Button btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        btnAnswer2.setText(answers[1] + "");
        Button btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);
        btnAnswer3.setText(answers[2] + "");
        Button btnAnswer4 = (Button) findViewById(R.id.btnAnswer4);
        btnAnswer4.setText(answers[3] + "");

        //Button btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        btnAnswer1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ArrayList<Question> myList1 = (ArrayList<Question>) getIntent().getSerializableExtra("questionList");
                int nextQuestion = myList1.size();
                // find the next unanswered question
                for (int i = 0; i < myList1.size(); i++) {
                    if (!myList1.get(i).getIsAnswered()) {
                        nextQuestion = i;
                        break;
                    }
                }

                Question q = myList1.get(nextQuestion);
                int[] answers = q.getAnswers();

                // see if the correct answer was tied to this button
                if (q.getCorrectAnswer() == 0) {
                    //mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_correct + MainActivity.languageOffset);
                    mpC.start();
                    myList1.get(nextQuestion).setIsCorrect(true);
                } else {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_000 + answers[0] + MainActivity.languageOffset);
                    mp.start();
                    myList1.get(nextQuestion).setIsCorrect(false);
                }

                myList1.trimToSize();
                //if (nextQuestion >= 8) {
                if (nextQuestion >= (myList1.size() - 1)) {
                    Intent intent = new Intent(v.getContext(), ResultActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                }
            }
        });

        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Question> myList1 = (ArrayList<Question>) getIntent().getSerializableExtra("questionList");
                int nextQuestion = 0;
                // find the next unanswered question
                for (int i = 0; i < myList1.size(); i++) {
                    if (!myList1.get(i).getIsAnswered()) {
                        nextQuestion = i;
                        break;
                    }
                }

                Question q = myList1.get(nextQuestion);
                int[] answers = q.getAnswers();

                // see if the correct answer was tied to this button
                if (q.getCorrectAnswer() == 1) {
                    //mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_correct + MainActivity.languageOffset);

                    mpC.start();
                    myList1.get(nextQuestion).setIsCorrect(true);
                } else {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_000 + answers[1] + MainActivity.languageOffset);
                    mp.start();
                    myList1.get(nextQuestion).setIsCorrect(false);
                }

                myList1.trimToSize();
                //if (nextQuestion >= 8) {
                if (nextQuestion >= (myList1.size() - 1)) {
                    Intent intent = new Intent(v.getContext(), ResultActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                }

            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Question> myList1 = (ArrayList<Question>) getIntent().getSerializableExtra("questionList");
                int nextQuestion = 0;
                // find the next unanswered question
                for (int i = 0; i < myList1.size(); i++) {
                    if (!myList1.get(i).getIsAnswered()) {
                        nextQuestion = i;
                        break;
                    }
                }

                Question q = myList1.get(nextQuestion);
                int[] answers = q.getAnswers();

                // see if the correct answer was tied to this button
                if (q.getCorrectAnswer() == 2) {
                    //mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_correct + MainActivity.languageOffset);
                    mpC.start();
                    myList1.get(nextQuestion).setIsCorrect(true);
                } else {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_000 + answers[2] + MainActivity.languageOffset);
                    mp.start();
                    System.out.println("audio");
                    myList1.get(nextQuestion).setIsCorrect(false);
                }

                myList1.trimToSize();
                //if (nextQuestion >= 8) {
                if (nextQuestion >= (myList1.size()-1)) {
                    Intent intent = new Intent(v.getContext(), ResultActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                }

            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Question> myList1 = (ArrayList<Question>) getIntent().getSerializableExtra("questionList");
                int nextQuestion = 0;
                // find the next unanswered question
                for (int i = 0; i < myList1.size(); i++) {
                    if (!myList1.get(i).getIsAnswered()) {
                        nextQuestion = i;
                        break;
                    }
                }

                Question q = myList1.get(nextQuestion);
                int [] answers = q.getAnswers();

                // see if the correct answer was tied to this button
                if (q.getCorrectAnswer() == 3) {
                    //mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_correct + MainActivity.languageOffset);
                    mpC.start();
                    myList1.get(nextQuestion).setIsCorrect(true);
                } else {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.lang1_000 + answers[3] + MainActivity.languageOffset);
                    mp.start();
                    myList1.get(nextQuestion).setIsCorrect(false);
                }

                myList1.trimToSize();

                // check to make sure we haven't answered all questions
                if (nextQuestion >= (myList1.size()-1)) {
                    // done. Go to results
                    Intent intent = new Intent(v.getContext(), ResultActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                } else {
                    // There are more questions to answer
                    Intent intent = new Intent(v.getContext(), OperatorQuestionActivity.class);
                    intent.putExtra("questionList", myList1);
                    startActivity(intent);
                }

            }
        });

    }
}
