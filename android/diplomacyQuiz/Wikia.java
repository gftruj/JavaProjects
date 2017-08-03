package com.example.pionek.diplomacypls;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Wikia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wikia);
        storage S = new storage();


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);
        linearLayout.setBackgroundColor(Color.TRANSPARENT);

        //PRINT ITEMS
        for (storage.item i : S.getBase()) {

            //PRINT COUNTRY
            TextView countryTextView = new TextView(this);
            countryTextView.setText(i.kraj);
            countryTextView.setTextSize(20);
            countryTextView.setTypeface(null, Typeface.BOLD);
            linearLayout.addView(countryTextView);
            TextView stateState = new TextView(this);
            stateState.setText(i.state);
            linearLayout.addView(stateState);

            //PRINT REPRESENTATIVES
            TextView presentGovn = new TextView(this);
            presentGovn.setText("Representatives");
            presentGovn.setTextSize(15);
            presentGovn.setTypeface(null, Typeface.BOLD);
            linearLayout.addView(presentGovn);
            for(String a:i.figury) {
                TextView figuryTextView = new TextView(this);
                figuryTextView.setText(a);
                linearLayout.addView(figuryTextView);

            }
            //PRINT PARLIAMENT
            TextView presentCon = new TextView(this);
            presentCon.setText(i.legisType);
            presentCon.setTextSize(15);
            presentCon.setTypeface(null, Typeface.BOLD);
            linearLayout.addView(presentCon);
            for(String p:i.parlamenty) {
                TextView figuryTextView = new TextView(this);
                figuryTextView.setText(p);
                linearLayout.addView(figuryTextView);

            }
            TextView aa = new TextView(this);
            aa.setText("\n");
            linearLayout.addView(aa);

        }
    }
}


