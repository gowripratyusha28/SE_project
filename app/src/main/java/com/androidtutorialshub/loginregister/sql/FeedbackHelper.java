package com.androidtutorialshub.loginregister.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.model.Userfeedback;

public class FeedbackHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Feedback.db";

    // User table name
    private static final String TABLE_FEED = "feedback";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_PLACE_NAME = "place_name";
    private static final String COLUMN_FEEDBACK = "place_feedback";
    private static final String COLUMN_GENERAL = "general_feedback";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_FEED + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_PLACE_NAME + " TEXT," + COLUMN_FEEDBACK + " TEXT" + COLUMN_GENERAL + "TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_FEED;

    /**
     * Constructor
     *
     * @param context
     */
    public FeedbackHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param userfeedback
     */
    public void addUserfeedback(Userfeedback userfeedback) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, userfeedback.getName());
        values.put(COLUMN_PLACE_NAME, userfeedback.getPlacename());
        values.put(COLUMN_FEEDBACK, userfeedback.getPlacefeedback());
        values.put(COLUMN_GENERAL, userfeedback.getGeneralfeedback());
        // Inserting Row
        db.insert(TABLE_FEED, null, values);
        db.close();
    }


}
