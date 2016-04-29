package com.example.daniel.wednesdaymaths;

import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by brian on 28/04/2016.
 */
public class Question implements Serializable {

    private boolean isAnswered = false;
    private boolean isCorrect = false;


    private int operandL = 0;
    private int operandR = 0;
    private int operator;
    private int difficulty;
    private int maxL = 0;
    private int maxR = 0;
    private int minL = 0;
    private int minR = 0;
    private int [] answers = new int[4];
    private int correctAnswer = 0;

    //private int minCorrectAnswer = 0;

    public Question (int operator, int difficulty) {
        this.operator = operator;
        this.difficulty = difficulty;

        this.maxL = calcOperandMax();
        this.maxR = calcOperandMax();
        this.minL = calcOperandMin();
        this.minR = calcOperandMin();
        this.isAnswered = false;
        this.isCorrect = false;

        generateQuestion();
        this.correctAnswer = generateAnswers();

    }

    public int calcOperandMax() {

        if (this.operator == MainActivity.OPERATOR_ADD) {

            return 10 * this.difficulty;

        } else if (operator == MainActivity.OPERATOR_SUB) {
            return 10 * this.difficulty;

        } else if (operator == MainActivity.OPERATOR_MUL) {
            return 5 + this.difficulty;

        } else {
            return 5 + this.difficulty;
        }

    }

    public int calcOperandMin() {
        if (operator == MainActivity.OPERATOR_ADD) {
            return this.difficulty;

        } else if (operator == MainActivity.OPERATOR_SUB) {
            return this.difficulty;

        } else if (operator == MainActivity.OPERATOR_MUL) {
            return this.difficulty;

        } else {
            return 2;
        }
    }

    // generate questions
    public void generateQuestion() {

        if (operator == MainActivity.OPERATOR_ADD) {
            int diffl = (this.maxL - this.minL) + 1;
            int diffr = (this.maxR - this.minR) + 1;

            this.operandL = (int) (Math.random() * diffl) + this.minL;
            this.operandR = (int) (Math.random() * diffr) + this.minR;

        } else if (operator == MainActivity.OPERATOR_SUB) {
            int diffl = (this.maxL - this.minL) + 1;
            int diffr = (this.maxR - this.minR) + 1;

            this.operandL = (int) (Math.random() * diffl) + this.minL;
            this.operandR = (int) (Math.random() * diffr) + this.minR;

            // swap R to L if R > L
            if (this.operandL < this.operandR) {
                int temp = this.operandL;
                this.operandL = this.operandR;
                this.operandR = temp;

            }
        } else if (operator == MainActivity.OPERATOR_MUL) {
            int diffl = (this.maxL - this.minL) + 1;
            int diffr = (this.maxR - this.minR) + 1;

            this.operandL = (int) (Math.random() * diffl) + this.minL;
            this.operandR = (int) (Math.random() * diffr) + this.minR;

        } else {
            int diffl = (this.maxL - this.minL) + 1;
            int diffr = (this.maxR - this.minR) + 1;

            this.operandL = (int) (Math.random() * diffl) + this.minL;
            this.operandR = (int) (Math.random() * diffr) + this.minR;

            int temp = this.operandL;
            this.operandL = this.operandL * this.operandR;
            this.operandR = temp;

        }

    }

    public int generateAnswers() {

        int answerIndex = (int)(Math.random()*4);

        if (operator == MainActivity.OPERATOR_ADD) {
            //int offset = 1;

            int start = (this.operandL + this.operandR) - answerIndex;

            if (start <=0 ) {
                start = (this.operandL + this.operandR) +1;
                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
                this.answers[answerIndex] = (this.operandL + this.operandR);
            } else {

                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
            }

        } else if (operator == MainActivity.OPERATOR_SUB) {

            int start = (this.operandL - this.operandR) - answerIndex;

            /*for (int i = 0; i < this.answers.length; i++) {

                this.answers[i] = start++;

            }*/
            if (start <=0 ) {
                start = (this.operandL - this.operandR) +1;
                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
                this.answers[answerIndex] = (this.operandL - this.operandR);
            } else {

                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
            }


        } else if (operator == MainActivity.OPERATOR_MUL) {

            int start = (this.operandL * this.operandR) - answerIndex;

            if (start <=0 ) {
                start = (this.operandL * this.operandR) +1;
                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
                this.answers[answerIndex] = (this.operandL * this.operandR);
            } else {

                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
            }

        } else {
            /*
            int x = this.operandL;
            int y = this.operandR;
            int z = this.operandL * this.operandR;*/

            int start = (this.operandL / this.operandR) - answerIndex;


            if (start <=0 ) {
                start = (this.operandL / this.operandR) +1;
                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
                this.answers[answerIndex] = (this.operandL / this.operandR);
            } else {

                for (int i = 0; i < this.answers.length; i++) {
                    this.answers[i] = start++;
                }
            }
        }

        return answerIndex;
    }

    public int [] getAnswers() {
        return this.answers;
    }

    public String toString() {
        String strOp = (operator == MainActivity.OPERATOR_ADD) ? "+" : ((operator == MainActivity.OPERATOR_SUB) ? "-" : ((operator == MainActivity.OPERATOR_MUL) ? "x" : "/"));

        return this.operandL + " " + strOp + " " + this.operandR;
    }

    public int getDifficulty() {

        return this.difficulty;
    }

    public void setIsCorrect(boolean correct) {
        this.isCorrect = correct;
        this.isAnswered = true;

    }

    public boolean getIsAnswered() {
        return this.isAnswered;
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public int getOperator() {
        return this.operator;
    }

}
