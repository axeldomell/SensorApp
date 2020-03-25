package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  public static final String EXTRA_MESSAGE = "com.example.sensorApp.MESSAGE";
  public static final String message = "message";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void showCompass(View view){
    Intent intent = new Intent(this, CompassActivity.class);
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
  }

  public void showAccelerometer(View view) {
    Intent intent = new Intent(this, AccelerometerActivity.class);
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
  }
}
