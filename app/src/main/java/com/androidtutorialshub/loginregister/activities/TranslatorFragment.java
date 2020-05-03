package com.androidtutorialshub.loginregister.activities;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TranslatorFragment#} factory method to
 * create an instance of this fragment.
 */
public class TranslatorFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_translator, container, false);
        Button btn = (Button) view.findViewById(R.id.gototranslator);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setComponent(new ComponentName(
                            "com.google.android.apps.translate",
                            //Change is here
                            //"com.google.android.apps.translate.HomeActivity"));
                            "com.google.android.apps.translate.TranslateActivity"));
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    Toast.makeText(getContext(), "Sorry, No Google Translation Installed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
