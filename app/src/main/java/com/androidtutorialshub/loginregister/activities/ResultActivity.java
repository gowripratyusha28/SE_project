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
    }
}
