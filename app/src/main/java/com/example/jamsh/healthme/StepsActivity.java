package com.example.jamsh.healthme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StepsActivity extends AppCompatActivity implements SensorEventListener {

    private String temp;
    private SensorManager sensorManager;
    private TextView count;
    boolean activity_running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        count =(TextView) findViewById(R.id.text3);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    protected void onResume(){
        super.onResume();
        activity_running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor!=null)
        {
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(this,"Count sensor not available!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        activity_running = false;

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(activity_running)
        {
            count.setText(String.valueOf(event.values[0]) + "\r\nsteps");
            temp = String.valueOf(event.values[0]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void myfunction(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",temp);
        setResult(2,returnIntent);
        finish();


    }
}
