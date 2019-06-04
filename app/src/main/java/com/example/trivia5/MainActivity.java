package com.example.trivia5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements QuestionsRequest.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartOnClick(View view) {
        QuestionsRequest request = new QuestionsRequest(this);
        request.getQuestions( this);
    }

    @Override
    public void gotQuestionlist(ArrayList<Question> someQuestions) {
        Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
        intent.putExtra("questions", someQuestions);
        startActivity(intent);
    }

    @Override
    public void gotQuestionlistError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
