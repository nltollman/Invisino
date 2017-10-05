package com.invisino.invisino;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/*
Created by Maggie Gembala: 10-3-2017
 */

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

public class MainCameraActivity extends AppCompatActivity {

    private Camera mCamera = null;
    private CameraView mCameraView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_camera);

        if (!(CameraPermissionHelper.hasCameraPermission(this))) {
            CameraPermissionHelper.requestCameraPermission(this);
        }

        try {
            mCamera = Camera.open();//you can use open(int) to use different cameras
        } catch (Exception e) {
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if (mCamera != null) {
            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
            FrameLayout camera_view = (FrameLayout) findViewById(R.id.fullscreen_content_frame);
            camera_view.addView(mCameraView);//add the SurfaceView to the layout
        }

        Button newNoteButton = (Button) findViewById(R.id.plus_button);
        newNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), NewNoteActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });

        Button settingsButton = (Button) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(view.getContext(), SettingsActivity.class);
                startActivityForResult(nextScreen, 0);
            }
        });
    }
}
