package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.activities.TripFragment;

public class ResultActivity extends AppCompatActivity {

    public String placenames[] = {"","RamaKrishna Beach", "Simhachalam", "Yarada Beach", "Kailasgiri Hill Park", "Kambalakonda Wild Life Sanctuary",
            "Indira Gandhi Zoological Park", "RushiKonda Beach", "Vuda Park", "City Central Park", "CMR Central Mall", "TU 142 Air Craft Museum", "Dolphins Nose" };
    public String placeurl[] = {"","google.navigation:q=Ramakrishna+Beach,+Visakhapatnam+India","google.navigation:q=Simhachalam+Devasthanam,+Visakhapatnam+India",
                                "google.navigation:q=Yarada+Beach,+Visakhapatnam+India","google.navigation:q=Kailsagiri+Park,+Visakhapatnam+India",
                                "google.navigation:q=Kambalakonda+Wild+Life+Sanctuary,+Visakhapatnam+India","google.navigation:q=Indira+Gandhi+Zoological+Park,+Visakhapatnam+India",
                                "google.navigation:q=Rushikonda+Beach,+Visakhapatnam+India","google.navigation:q=Vuda+Park,+Visakhapatnam+India",
                                "google.navigation:q=City+Cantral+Park,+Visakhapatnam+India","google.navigation:q=CMR+Central,+Visakhapatnam+India", "google.navigation:q=Dolphins+Nose,+Visakhapatnam+India"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String msg = "";
        for(int i=1;i<TripFragment.placesorder.length;i++){
            msg += i + "." + placenames[TripFragment.placesorder[i]] + "\n";
        }
        TextView text = (TextView) findViewById(R.id.displayorder);
        text.setText(msg);
        TextView text2 = (TextView) findViewById(R.id.totalcost);
        text2.setText(TripFragment.totalcost);
        TextView text3 = (TextView) findViewById(R.id.totaltime);
        text3.setText(TripFragment.totaltime);
        TextView text4 = (TextView) findViewById(R.id.displayorder1);
        text4.setText(TripFragment.message);
        TextView text5 = (TextView) findViewById(R.id.totalcost1);
        text5.setText(TripFragment.totalcost);
        TextView text6 = (TextView) findViewById(R.id.totaltime1);
        text6.setText(TripFragment.totaltime);
    }

    public void Click(View view){
        Uri gmmIntentUri = Uri.parse(placeurl[TripFragment.placesorder[1]]);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}
