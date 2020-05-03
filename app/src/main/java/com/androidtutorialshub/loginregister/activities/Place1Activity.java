package com.androidtutorialshub.loginregister.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;

public class Place1Activity extends AppCompatActivity {

    public String placenames[] = {"","RamaKrishna Beach", "Simhachalam", "Yarada Beach", "Kailasgiri Hill Park", "Kambalakonda Wild Life Sanctuary",
            "Indira Gandhi Zoological Park", "RushiKonda Beach", "Vuda Park", "City Central Park", "CMR Central", "TU 142 Air Craft Museum", "Dolphins Nose" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place1);
        if(PlacesFragment.number == 0){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[1]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.rk1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.rk2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place1);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("The Supreme Hotel");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("The Square Restaurant");
        }
        else if(PlacesFragment.number == 1){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[2]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.simhachalam1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.simhachalam2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place2);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Kumari Hotel");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Vatan Restaurant");
        }
        else if(PlacesFragment.number == 2){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[3]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.yarada1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.yarada2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place3);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Hotel Daspalla");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Yarada Restaurant");
        }
        else if(PlacesFragment.number == 3){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[4]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.kh1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.kh2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place4);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("The Park Visakhapatnam");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Happyoi Restaurant");
        }
        else if(PlacesFragment.number == 4){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[5]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.kws1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.kws2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place5);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Treebo Trend Grand");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Seven Eleven Restaurant");
        }
        else if(PlacesFragment.number == 5){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[6]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.ig1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.ig2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place6);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Modern Villa");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Diamond Restaurant");
        }
        else if(PlacesFragment.number == 6){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[7]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.rushi1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.rushi2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place7);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Fairfield Marriot");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Sea Inn Restaurant");
        }
        else if(PlacesFragment.number == 7){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[8]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.vuda1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.vuda2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place8);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Fairfield Marriot");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Kava Grill Restaurant");
        }
        else if(PlacesFragment.number == 8){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[9]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.ccp1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.ccp2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place9);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Hotel Green Park");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Zeeshan Restaurant");
        }
        else if(PlacesFragment.number == 9){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[10]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.cmr1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.cmr2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place10);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Mantris Hotel");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Tycoon Restaurant");
        }
        else if(PlacesFragment.number == 10){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[11]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.air1);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.air2);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place11);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("The Park Visakhapatnam Hotel");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Infinity Restaurant");
        }
        else if(PlacesFragment.number == 11){
            TextView txt = (TextView) findViewById(R.id.nameofplace);
            txt.setText(placenames[12]);
            ImageView image1 = (ImageView) findViewById(R.id.image1);
            image1.setImageResource(R.drawable.dol2);
            ImageView imag2 = (ImageView) findViewById(R.id.image2);
            imag2.setImageResource(R.drawable.dol1);
            TextView text = (TextView) findViewById(R.id.textaboutplace);
            text.setText(R.string.place12);
            TextView text1 = (TextView) findViewById(R.id.hotelname);
            text1.setText("Best Western Ramachandra Hotel");
            TextView text2 = (TextView) findViewById(R.id.restaurantname);
            text2.setText("Horizon Restaurant");
        }
    }
}
