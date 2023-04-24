package com.example.flashapp;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout;
    CameraManager cameraManager;
    String cameraId;
    boolean state=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout=findViewById(R.id.click);
        layout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if(state==false){
                    try{
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cameraId=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraId,!state);
                        layout.setBackgroundResource(R.drawable.on);
                        state=true;
                    } catch (CameraAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    try {
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cameraId=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraId,!state);
                        layout.setBackgroundResource(R.drawable.off);
                        state=false;
                    } catch (CameraAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


    }
}
