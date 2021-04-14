package com.androidtutorialshub.loginregister.activities;
/**Java file to show different fragments**/
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.adapters.UsersRecyclerAdapter;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private AppCompatTextView textViewName;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();
    }

    private void initViews() {
        //ButtonLogin = (Button) findViewById(R.id.feedback);
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        email = emailFromIntent;
        textViewName.setText(emailFromIntent);
    }

    public void sendtofeedback(View view){
        Intent intentRegister = new Intent(getApplicationContext(), FeedbackActivity.class);
        intentRegister.putExtra("EMAIL",email);
        startActivity(intentRegister);
    }


//
//    private void initListeners() {
//        ButtonLogin.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//
//            case R.id.feedback:
//                Intent intentRegister = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intentRegister);
//                break;
//
//            case R.id.appCompatTextViewLoginLink:
//                finish();
//                break;
//        }
//    }
}
