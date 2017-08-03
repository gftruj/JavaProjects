package com.example.pionek.diplomacypls;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
// QUITE PRIMITIVE SELF MADE SEARCH ENGINE, WHICH MATCHES THE STRING WITH THE RECORDS IN THE STORAGE CLASS
//TODO: MAKE IT WORK FOR SINGLE NAME INPUTS ETC.
public class SearchEngine extends AppCompatActivity {
    storage storage = new storage();
    String a = "a";
    String parsed = "a";
    String tmp;
    boolean found = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        parsed = getIntent().getStringExtra(parsed);
        tmp = parsed;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);
        tmp = tmp.replaceAll("//s","");
        for (storage.item i : storage.getBase()) {


            if(tmp.equals(i.kraj)||tmp.equals(i.kraj.toLowerCase())
                    ||tmp.equals(i.figury.get(0).replaceAll("//s",""))||tmp.equals(i.figury.get(0).replaceAll("//s","").toLowerCase())
                    ||tmp.equals(i.figury.get(1).replaceAll("//s",""))||tmp.equals(i.figury.get(1).replaceAll("//s","").toLowerCase())
                    ){
                found = true;
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
                //PRINT Representatives
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

            }

        }
        if(!found){
            TextView presentCon = new TextView(this);
            presentCon.setText("No Such Entries" +
                    "");
            presentCon.setTextSize(15);
            presentCon.setTypeface(null, Typeface.BOLD);
            linearLayout.addView(presentCon);
        }
    }
}
