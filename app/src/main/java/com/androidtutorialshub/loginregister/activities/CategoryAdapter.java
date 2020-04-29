package com.androidtutorialshub.loginregister.activities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androidtutorialshub.loginregister.R;

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new PlacesFragment();
        }
        else if(position == 1){
            return new NewPlaceFragment();
        } else {
            return new TripFragment();
        } /*else {
            return new PhrasesFragment();
        }*/
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_places);
        } else if(position == 1){
            return mContext.getString(R.string.category_newplace);
        }
        else{
            return mContext.getString(R.string.trip);
        }

    }
}