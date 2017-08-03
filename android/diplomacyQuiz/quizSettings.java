package com.example.pionek.diplomacypls;
/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class quizSettings extends AppCompatActivity {
    ToggleButton askPresident, askPrime, askParliament;
    protected MainActivity app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_settings);
        app = (MainActivity)getBaseContext();
        askPresident = (ToggleButton)findViewById(R.id.toggleAskPresident);
        askPrime = (ToggleButton)findViewById(R.id.toggleAskPrime);
        askParliament = (ToggleButton)findViewById(R.id.toggleAskParliament);
    }

    public void onAskPrimeToggle(View view){
        if (askPrime.isChecked()) {
            Toast.makeText(getApplicationContext(),"Prime Minister questions included",Toast.LENGTH_SHORT).show();
            app.setPrimeQuestions(true);
        }else{
            Toast.makeText(getApplicationContext(),"Prime Minister questions excluded",Toast.LENGTH_SHORT).show();
            app.setPrimeQuestions(false);
        }
    }
    public void onAskPresidentToggle(View view){
        if (askPresident.isChecked()) {
            Toast.makeText(getApplicationContext(), "President questions included", Toast.LENGTH_SHORT).show();
            app.setPresidentQuestions(true);
        }else{
            Toast.makeText(getApplicationContext(), "President questions excluded", Toast.LENGTH_SHORT).show();
            app.setPresidentQuestions(false);
        }
    }
    public void onAskParliamentToggle(View view){
        if (askParliament.isChecked()) {
            Toast.makeText(getApplicationContext(), "Parliament questions included", Toast.LENGTH_SHORT).show();
            app.setParliamentQuestions(true);
        }else{
            Toast.makeText(getApplicationContext(), "Parliament questions excluded", Toast.LENGTH_SHORT).show();
            app.setParliamentQuestions(false);
        }
    }
}
*/