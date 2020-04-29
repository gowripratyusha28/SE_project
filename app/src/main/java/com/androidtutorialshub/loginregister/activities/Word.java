package com.androidtutorialshub.loginregister.activities;

public class Word {
    private String mPlaceName;
    private int mImageResourceId;

    public Word(String placeName, int imageResourceId){
        mPlaceName = placeName;
        mImageResourceId = imageResourceId;
    }

    public String getPlaceName(){
        return mPlaceName;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

}
