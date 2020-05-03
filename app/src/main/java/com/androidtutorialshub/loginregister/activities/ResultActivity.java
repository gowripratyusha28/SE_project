package com.androidtutorialshub.loginregister.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.activities.TripFragment;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView text = (TextView) findViewById(R.id.displayorder);
        text.setText(TripFragment.message);
        TextView text2 = (TextView) findViewById(R.id.totalcost);
        text2.setText(TripFragment.totalcost);
        TextView text3 = (TextView) findViewById(R.id.totaltime);
        text3.setText(TripFragment.totaltime);
        TextView text4 = (TextView) findViewById(R.id.displayorder1);
        text4.setText(TripFragment.message1);
        TextView text5 = (TextView) findViewById(R.id.totalcost1);
        text5.setText(TripFragment.totalcost);
        TextView text6 = (TextView) findViewById(R.id.totaltime1);
        text6.setText(TripFragment.totaltime);
    }
}
