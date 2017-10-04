package com.invisino.invisino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Created by Maggie Gembala: 10-4-2017
 */

public class ViewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        Button editNote = (Button) findViewById(R.id.edit_note);
        editNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), NewNoteActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button deleteNote = (Button) findViewById(R.id.delete_note);
        deleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), MainCameraActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button exitButton = (Button) findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), MainCameraActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
    }
}
