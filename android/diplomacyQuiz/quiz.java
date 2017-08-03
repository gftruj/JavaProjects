package com.example.pionek.diplomacypls;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//TODO: LOTS OF THING SET UP MANUALLY, SURELY I COULD DO THIS DYNAMICALLY WITH LESS LINES
//TODO: APPARENTLY SOMETIMES I GET 2 SAME WRONG ANWSERS, CHECK WTH IS WITH THE RANDOMIZER
public class quiz extends AppCompatActivity {
    storage intel;
    quizRandomizer qr;
    int rightAnwser,ra,wa;
    Button anws1, anws2, anws3,resetButton;
    TextView rightAnwsers,wrongAnwsers,title,countryTextView;
    LinearLayout linearLayout;
    ArrayList<String> countries,anwsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setContentView(R.layout.activity_search_engine);
        linearLayout = (LinearLayout) findViewById(R.id.layout);

        title = new TextView(this);
        title.setText("Select the right button\n\n");
        title.setTextSize(25);
        title.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(title);

        countryTextView = new TextView(this);
        countryTextView.setText("loading");
        countryTextView.setTextSize(15);
        countryTextView.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(countryTextView);

        anws1 = new Button(this);
        anws1.setText("loading");
        anws1.setTextSize(15);
        anws1.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(anws1);

        anws2 = new Button(this);
        anws2.setText("loading");
        anws2.setTextSize(15);
        anws2.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(anws2);

        anws3 = new Button(this);
        anws3.setText("loading");
        anws3.setTextSize(15);
        anws3.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(anws3);

        resetButton = new Button(this);
        resetButton.setText("Next");
        resetButton.setTextSize(10);
        resetButton.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(resetButton);
        ra=0;
        wa=0;
        rightAnwsers = new TextView(this);
        rightAnwsers.setText("Right Anwsers: "+ra);
        rightAnwsers.setTextSize(10);
        rightAnwsers.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(rightAnwsers);

        wrongAnwsers = new TextView(this);
        wrongAnwsers.setText("Wrong Anwsers: "+wa);
        wrongAnwsers.setTextSize(10);
        wrongAnwsers.setTypeface(null, Typeface.BOLD);
        linearLayout.addView(wrongAnwsers);

        createQuiz();

    }
    public void createQuiz(){
        anws1.setBackgroundColor(Color.LTGRAY);
        anws2.setBackgroundColor(Color.LTGRAY);
        anws3.setBackgroundColor(Color.LTGRAY);
        intel = new storage();
        qr = new quizRandomizer();
        qr.getRandom((intel.base.size() - 1));

        qr.gr();


        // Random of figures, parliament, state
        int setup = (int) (Math.random() * 4);
        anwsers = new ArrayList<String>(3);
        countries = new ArrayList<String>(3);

        long seed = System.nanoTime();


        if (setup == 0) {
            //STATE
            System.out.println("s0");
            title.setText("Match the country with the state:\n\n");

            anwsers.add(intel.base.get(qr.values[0]).state.toString());
            anwsers.add(intel.base.get(qr.values[1]).state.toString());
            anwsers.add(intel.base.get(qr.values[2]).state.toString());
            countries.add(intel.base.get(qr.values[0]).kraj);
            countries.add(intel.base.get(qr.values[1]).kraj);
            countries.add(intel.base.get(qr.values[2]).kraj);
            Collections.shuffle(anwsers, new Random(seed));
            Collections.shuffle(countries, new Random(seed));
        } else if (setup == 1) {
            System.out.println("s1");
            title.setText("Match the country with the Representative:\n\n");

            anwsers.add(intel.base.get(qr.values[0]).figury.get(0).toString());
            anwsers.add(intel.base.get(qr.values[1]).figury.get(0).toString());
            anwsers.add(intel.base.get(qr.values[2]).figury.get(0).toString());
            countries.add(intel.base.get(qr.values[0]).kraj);
            countries.add(intel.base.get(qr.values[1]).kraj);
            countries.add(intel.base.get(qr.values[2]).kraj);
            Collections.shuffle(anwsers, new Random(seed));
            Collections.shuffle(countries, new Random(seed));
        } else if (setup == 2) {
            title.setText("Match the country with the Representative:\n\n");
            anwsers.add(intel.base.get(qr.values[0]).figury.get(1).toString());
            anwsers.add(intel.base.get(qr.values[1]).figury.get(1).toString());
            anwsers.add(intel.base.get(qr.values[2]).figury.get(1).toString());
            countries.add(intel.base.get(qr.values[0]).kraj);
            countries.add(intel.base.get(qr.values[1]).kraj);
            countries.add(intel.base.get(qr.values[2]).kraj);
            Collections.shuffle(anwsers, new Random(seed));
            Collections.shuffle(countries, new Random(seed));

        } else if (setup == 3) {
            title.setText("Match the country with the parliament:\n\n");
            anwsers.add(intel.base.get(qr.values[0]).parlamenty.get(0).toString());
            anwsers.add(intel.base.get(qr.values[1]).parlamenty.get(0).toString());
            anwsers.add(intel.base.get(qr.values[2]).parlamenty.get(0).toString());
            countries.add(intel.base.get(qr.values[0]).kraj);
            countries.add(intel.base.get(qr.values[1]).kraj);
            countries.add(intel.base.get(qr.values[2]).kraj);
            Collections.shuffle(anwsers, new Random(seed));
            Collections.shuffle(countries, new Random(seed));

        } else {
            title.setText("Match the country with the legislation type:\n\n");
            anwsers.add(qr.values1[0], intel.base.get(qr.values[0]).legisType.toString());
            anwsers.add(qr.values1[1], intel.base.get(qr.values[1]).legisType.toString());
            anwsers.add(qr.values1[2], intel.base.get(qr.values[2]).legisType.toString());
            countries.add(intel.base.get(qr.values[0]).kraj);
            countries.add(intel.base.get(qr.values[1]).kraj);
            countries.add(intel.base.get(qr.values[2]).kraj);
            Collections.shuffle(anwsers, new Random(seed));
            Collections.shuffle(countries, new Random(seed));
        }
        countryTextView.setText(intel.base.get(qr.values[0]).kraj.toString());
        anws1.setText(anwsers.get(0));
        anws2.setText(anwsers.get(1));
        anws3.setText(anwsers.get(2));

        //THIS IS RETARDED, TODO: PUT THIS IN AN ARRAY AND MAKE IT IN A LOOP:
        anws1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countries.get(0).toString().equals(countryTextView.getText())) {
                    anws1.setBackgroundColor(Color.GREEN);
                    onRight();
                    anws2.setClickable(false);
                    anws3.setClickable(false);
                } else {
                    anws1.setBackgroundColor(Color.RED);
                    onWrong();
                }
                anws1.setClickable(false);

            }
        });
        anws2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (countries.get(1).toString().equals(countryTextView.getText())) {
                    anws2.setBackgroundColor(Color.GREEN);
                    onRight();
                    anws1.setClickable(false);
                    anws3.setClickable(false);
                } else {
                    anws2.setBackgroundColor(Color.RED);
                    onWrong();
                }
                anws2.setClickable(false);

            }
        });

        anws3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (countries.get(2).toString().equals(countryTextView.getText())) {
                    anws3.setBackgroundColor(Color.GREEN);
                    onRight();
                    anws2.setClickable(false);
                    anws1.setClickable(false);

                } else {
                    anws3.setBackgroundColor(Color.RED);
                    onWrong();
                }
                anws3.setClickable(false);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stu


                createQuiz();

            }
        });
    }
    public void onRight(){
        ra++;
        rightAnwsers.setText("Right Anwsers: "+ra);
    }
    public void onWrong(){
        wa++;
        wrongAnwsers.setText("Wrong Anwsers: "+wa);
    }
}
