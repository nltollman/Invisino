package com.invisino.invisino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Created by Maggie Gembala: 10-3-2017
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerSubmitButton = (Button) findViewById(R.id.register_submit_button);
        registerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), LoginActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
        Button registerCancelButton = (Button) findViewById(R.id.register_cancel_button);
        registerCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), MainCameraActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
    }
}
