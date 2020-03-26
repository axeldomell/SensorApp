package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
  private TextView xValue, yValue, zValue, currentTilt;
  Sensor accelerometerSensor;
  SensorManager sensorManager;
  MediaPlayer mpLeft;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_accelerometer);
    sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_UI);
    mpLeft =  MediaPlayer.create(this, R.raw.sound2);

    xValue = findViewById(R.id.AccX);
    yValue = findViewById(R.id.AccY);
    zValue = findViewById(R.id.AccZ);
    currentTilt = findViewById(R.id.tilt);
  }


  @Override
  public void onSensorChanged(SensorEvent event) {
    Sensor sensor2 = event.sensor;
    if (sensor2.getType() == Sensor.TYPE_ACCELEROMETER) {
      xValue.setText(String.valueOf(event.values[0]));
      yValue.setText(String.valueOf(event.values[1]));
      zValue.setText(String.valueOf(event.values[2]));
    }
    if(event.values[0]<0){
      currentTilt.setText("Right");

      mpLeft.start();
    }else{
      currentTilt.setText("Left");
    }
  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {

  }
}
