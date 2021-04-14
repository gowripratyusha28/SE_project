package com.androidtutorialshub.loginregister.sql;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.androidtutorialshub.loginregister.model.Hospital;
import com.androidtutorialshub.loginregister.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_FEED = "feedback";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_AGE = "user_age";
    private static final String COLUMN_USER_HOSP = "user_hosp";

    //Hospital Table col names
    private static final String COLUMN_FEED_EMAIL = "user_email";
    private static final String COLUMN_FEED_BACK = "feedback";


//    private static String DB_PATH = "";
//    private final Context myContext;
//    private SQLiteDatabase myDataBase;
//    private SQLiteOpenHelper sqLiteOpenHelper;
//    public static final String HOSPITAL = "hosp";


    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_AGE + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT,"
            + COLUMN_USER_HOSP + " TEXT" + ")";

    private String CREATE_FEED_TABLE = "CREATE TABLE " + TABLE_FEED + "("
            + COLUMN_FEED_EMAIL + " TEXT,"
            + COLUMN_FEED_BACK + " TEXT" + ")";

    // create table sql query
//    private String CREATE_HOSP_TABLE = "CREATE TABLE " + TABLE_HOSP + "("
//            + COLUMN_HOSP_ID + " INTEGER PRIMARY KEY,"
//            + COLUMN_HOSP_NAME + " TEXT,"
//            + COLUMN_HOSP_EMAIL + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    //private String DROP_FEED_TABLE = "DROP TABLE IF EXISTS " + TABLE_FEED;

    /**
     * Constructor
     * 
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

//    public void createDataBase()
//            throws IOException
//    {
//
//        boolean dbExist = checkDataBase();
//
//        if (dbExist) {
//            // do nothing - database already exist
//        }
//        else {
//            // By calling this method and
//            // the empty database will be
//            // created into the default system
//            // path of your application
//            // so we are gonna be able
//            // to overwrite that database
//            // with our database.
//            this.getWritableDatabase();
//            try {
//                copyDataBase();
//            }
//            catch (IOException e) {
//                throw new Error(
//                        "Error copying database");
//            }
//        }
//    }
//
//    private boolean checkDataBase()
//    {
//        SQLiteDatabase checkDB = null;
//        try {
//            String myPath = DB_PATH;
//            checkDB
//                    = SQLiteDatabase
//                    .openDatabase(
//                            myPath, null,
//                            SQLiteDatabase.OPEN_READONLY);
//        }
//        catch (SQLiteException e) {
//
//            // database doesn't exist yet.
//            Log.e("message", "" + e);
//        }
//        if (checkDB != null) {
//            checkDB.close();
//        }
//        return checkDB != null;
//    }
//
//    private void copyDataBase()
//            throws IOException
//    {
//        // Open your local db as the input stream
//        InputStream myInput
//                = myContext.getAssets()
//                .open("hosp.db");
//
//        // Path to the just created empty db
//        String outFileName = DB_PATH;
//
//        // Open the empty db as the output stream
//        OutputStream myOutput
//                = new FileOutputStream(outFileName);
//
//        // transfer bytes from the
//        // inputfile to the outputfile
//        byte[] buffer = new byte[1024];
//        int length;
//        while ((length = myInput.read(buffer)) > 0) {
//            myOutput.write(buffer, 0, length);
//        }
//
//        // Close the streams
//        myOutput.flush();
//        myOutput.close();
//        myInput.close();
//    }
//
//    public void openDataBase()
//            throws SQLException
//    {
//        // Open the database
//        String myPath = DB_PATH;
//        myDataBase = SQLiteDatabase
//                .openDatabase(
//                        myPath, null,
//                        SQLiteDatabase.OPEN_READONLY);
//    }
//
//    @Override
//    public synchronized void close()
//    {
//        // close the database.
//        if (myDataBase != null)
//            myDataBase.close();
//        super.close();
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FEED_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
       // db.execSQL(DROP_FEED_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_AGE, user.getAge());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_HOSP,user.getHosp());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addFeedback(String email,String feedback) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FEED_EMAIL, email);
        values.put(COLUMN_FEED_BACK, feedback);
        // Inserting Row
        db.insert(TABLE_FEED, null, values);
        db.close();
    }

//    public List<Hospital> getAllHospital(
//            Activity activity)
//    {
//        sqLiteOpenHelper
//                = new DatabaseHelper(activity);
//        SQLiteDatabase db
//                = sqLiteOpenHelper
//                .getWritableDatabase();
//
//        List<Hospital> list
//                = new ArrayList<>();
//
//        // query help us to return all data
//        // the present in the ALGO_TOPICS table.
//        String query = "SELECT * FROM " + HOSPITAL;
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Hospital hospital = new Hospital();
//                hospital.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_HOSP_ID))));
//                hospital.setName(cursor.getString(cursor.getColumnIndex(COLUMN_HOSP_NAME)));
//                hospital.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_HOSP_EMAIL)));
//                // Adding user record to list
//                list.add(hospital);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return list;
//    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_AGE,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_HOSP
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setAge(cursor.getString(cursor.getColumnIndex(COLUMN_USER_AGE)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setHosp(cursor.getString(cursor.getColumnIndex(COLUMN_USER_HOSP)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_AGE, user.getAge());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_HOSP, user.getHosp());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
