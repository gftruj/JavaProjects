package com.example.pionek.diplomacypls;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText MainSearch, MainSearch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainn);
        MainSearch = (EditText) findViewById(R.id.MainSearch);
        MainSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search(v);
                    return true;
                }
                return false;
            }
        });
    }
// THREE OPTIONS: SEARCH, WIKI, QUIZ
    public void search(View view) {
        Intent intent = new Intent(this, SearchEngine.class);
        String strName = null;
        intent.putExtra("a", MainSearch.getText().toString());
        startActivity(intent);
    }

    public void goToWiki(View view) {
        Intent intent = new Intent(this, Wikia.class);
        startActivity(intent);
    }

    public void goToQuiz(View view) {
        Intent intent = new Intent(this, quiz.class);
        startActivity(intent);
    }


}