package com.example.cookies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void change_view(View view){

        ImageView image = (ImageView) findViewById(R.id.image_change);
        image.setImageResource(R.drawable.after_cookie);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText("I'm so full");

    }
}
