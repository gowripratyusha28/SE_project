package com.androidtutorialshub.loginregister.activities;

import android.content.Context;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TableLayout;

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
        } else if(position == 2){
            return new TripFragment();
        } else if(position == 3){
            return new FeedbackFragment();
        }else{
            return new TranslatorFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_places);
        } else if(position == 1){
            return mContext.getString(R.string.category_newplace);
        }
        else if(position == 2){
            return mContext.getString(R.string.trip);
        }
        else if(position == 3){
            return mContext.getString(R.string.feedback);
        }
        else{
            return mContext.getString(R.string.translate);
        }
    }
}