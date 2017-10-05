package com.invisino.invisino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Created by Maggie Gembala: 10-4-2017
 */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button changeAccountInfoButton = (Button) findViewById(R.id.change_account_info_button);
        changeAccountInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), ChangeAccountInfoActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button viewMyNotesButton = (Button) findViewById(R.id.view_my_notes_button);
        viewMyNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), ViewMyExisitingNotesActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button signOutButton = (Button) findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), LoginActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), MainCameraActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
    }
}
