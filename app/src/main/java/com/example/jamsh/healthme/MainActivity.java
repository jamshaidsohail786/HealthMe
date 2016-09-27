package com.example.jamsh.healthme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private long date;
    private static final String APP="MIT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionlayout);



        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = datef.format(new Date(date));
        TextView set_date = (TextView) findViewById(R.id.myTitle);
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat  format = new SimpleDateFormat("dd/MM/yyyy");

        assert set_date != null;
        set_date.setText(format.format(ca.getTime()));


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void walkfunction(View v)
    {
        Intent i = new Intent(MainActivity.this,StepsActivity.class);
        startActivityForResult(i, 2);
        finish();
        overridePendingTransition(R.anim.push_down_in, R.anim.slide_out_left);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 2) {
                String result=data.getStringExtra("result");
                Toast.makeText(this,"Agaya",Toast.LENGTH_LONG).show();
        }
    }
}
