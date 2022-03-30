package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Team A methods */

    int team_a_score = 0;
    int team_b_score = 0;
    public void Team_A_threePointsMethod(View view){
        team_a_score += 3;
        display_team_A(team_a_score);
    }
    public void Team_A_twoPointsMethod(View view){
        team_a_score += 2;
        display_team_A(team_a_score);
    }
    public void Team_A_freePointsMethod(View view){
        team_a_score += 1;
        display_team_A(team_a_score);
    }

    /* Team B methods */

    public void Team_B_threePointsMethod(View view){
        team_b_score += 3;
        display_team_B(team_b_score);
    }
    public void Team_B_twoPointsMethod(View view){
        team_b_score += 2;
        display_team_B(team_b_score);
    }
    public void Team_B_freePointsMethod(View view){
        team_b_score += 1;
        display_team_B(team_b_score);
    }
    public void reset(View view){
        team_a_score = 0;
        team_b_score = 0;
        display_team_A(team_a_score);
        display_team_B(team_b_score);
    }

    /* Display methods */

    private void display_team_A(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.Team_a);
        quantityTextView.setText("" + number);
    }
    private void display_team_B(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.Team_b);
        quantityTextView.setText("" + number);
    }

}
