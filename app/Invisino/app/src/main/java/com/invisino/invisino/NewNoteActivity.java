package com.invisino.invisino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Created by Maggie Gembala: 10-4-2017
 */

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        Button postNewNoteButton = (Button) findViewById(R.id.post_new_note);
        postNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), ViewNoteActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button cancelNewNoteButton = (Button) findViewById(R.id.cancel_new_note);
        cancelNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), MainCameraActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
    }
}
