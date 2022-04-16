package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("where are you going?","minto wuksus"));
        words.add(new Word("what is you name?","tinnә oyaase'nә"));
        words.add(new Word("my name is ...","oyaaset..."));
        words.add(new Word("How are you feeling?","michәksәs?"));
        words.add(new Word("im feeling good.","kuchi achit"));
        words.add(new Word("are you coming?","әәnәs'aa?"));
        words.add(new Word("yes, i'm coming.","hәә’ әәnәm"));
        words.add(new Word("i'm coming.","әәnәm"));
        words.add(new Word("lets go. ","yoowutis"));
        words.add(new Word("come here.","әnni'nem"));

        WordAdapter adapter = new WordAdapter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}