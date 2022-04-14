package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");

        LinearLayout rootview = (LinearLayout) findViewById(R.id.rootview);
        /*
        TextView wordview = new TextView(this);
        wordview.setText(words.get(0));
        rootview.addView(wordview);

        TextView wordview1 = new TextView(this);
        wordview1.setText(words.get(1));
        rootview.addView(wordview1);
        */

        int i=0;

        while(i<5){
            TextView wordview = new TextView(this);
            wordview.setText(words.get(i));
            rootview.addView(wordview);
            i++;
        }


    }
}
