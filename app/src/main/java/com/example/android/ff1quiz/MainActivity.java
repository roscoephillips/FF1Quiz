package com.example.android.ff1quiz;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText question3Text;
    EditText question5Text;

    CheckBox question4A;
    CheckBox question4B;
    CheckBox question4C;
    CheckBox question4D;
    CheckBox question4E;
    CheckBox question4F;
    CheckBox question4G;

    RadioButton question1RadioButton;
    RadioButton question2RadioButton;
    RadioButton question6RadioButton;

    Typeface checkBoxFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxFont = Typeface.createFromAsset(getAssets(), "fonts/press_start_2p.ttf");

        question3Text = (EditText) findViewById(R.id.question_3_input);
        question5Text = (EditText) findViewById(R.id.question_5_input);

        question4A = (CheckBox) findViewById(R.id.question_4_1);
        question4A.setTypeface(checkBoxFont);
        question4B = (CheckBox) findViewById(R.id.question_4_2);
        question4B.setTypeface(checkBoxFont);
        question4C = (CheckBox) findViewById(R.id.question_4_3);
        question4C.setTypeface(checkBoxFont);
        question4D = (CheckBox) findViewById(R.id.question_4_4);
        question4D.setTypeface(checkBoxFont);
        question4E = (CheckBox) findViewById(R.id.question_4_5);
        question4E.setTypeface(checkBoxFont);
        question4F = (CheckBox) findViewById(R.id.question_4_6);
        question4F.setTypeface(checkBoxFont);
        question4G = (CheckBox) findViewById(R.id.question_4_7);
        question4G.setTypeface(checkBoxFont);


        question1RadioButton = (RadioButton) findViewById(R.id.question_1_correct);
        question2RadioButton = (RadioButton) findViewById(R.id.question_2_correct);
        question6RadioButton = (RadioButton) findViewById(R.id.question_6_correct);

    }


    /**
     * Default value for user score.
     */
    int userScore = 0;

    /**
     * Calculates the user's score.
     */
    private int calculateScore(int userScore) {
        return userScore * 100 / 6;
    }

    void submitTestResults(View v) {

        /**
         * Gives credit for question 1.
         */
        boolean isQuestion1Correct = question1RadioButton.isChecked();
        if (isQuestion1Correct) {
            userScore++;
        }

        /**
         * Gives credit for question 2.
         */
        boolean isQuestion2Correct = question2RadioButton.isChecked();
        if (isQuestion2Correct) {
            userScore++;
        }

        /**
         * Gives credit for question 3.
         */
        String question3Name = question3Text.getText().toString();
        if (question3Name.equalsIgnoreCase("bahamut")) {
            userScore++;
        }


        /**
         * Gives credit for question 4.
         */
        if (question4A.isChecked() &&
                question4B.isChecked() &&
                question4C.isChecked() &&
                !question4D.isChecked() &&
                question4E.isChecked() &&
                !question4F.isChecked() &&
                question4G.isChecked()) {
            userScore++;
        }


        /**
         * Gives credit for question 5.
         */
        try {
            int question5Quantity = Integer.parseInt(question5Text.getText().toString());
            if (question5Quantity == 55) {
                userScore++;
            }
        } catch (NumberFormatException blankQuestion) {
            Toast.makeText(this, getString(R.string.empty_question_5), Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * Gives credit for question 6.
         */
        boolean isQuestion6Correct = question6RadioButton.isChecked();
        if (isQuestion6Correct) {
            userScore++;
        }

        /**
         * Calculates final score and provides toast message.  Then, the score is reset to zero.
         */
        int score = calculateScore(userScore);
        if (score == 100) {
            String scoreMessage = getString(R.string.perfect_score, score);
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
        } else {
            String scoreMessage = getString(R.string.try_again, score);
            Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
        }

        userScore = 0;
    }

}



