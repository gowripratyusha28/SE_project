package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androidtutorialshub.loginregister.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewPlaceFragment#} factory method to
 * create an instance of this fragment.
 */
public class NewPlaceFragment extends Fragment {


    public NewPlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_new_place, container, false);
        Button btn =(Button) view.findViewById(R.id.submit);
        btn.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText nameedittext = (EditText) view.findViewById(R.id.name_edittext);
                String name = nameedittext.getText().toString();
                EditText emailedittext = (EditText) view.findViewById(R.id.email_edittext);
                String email = emailedittext.getText().toString();
                EditText placeedittext = (EditText) view.findViewById(R.id.placename_edittext);
                String place = placeedittext.getText().toString();
                EditText specification = (EditText) view.findViewById(R.id.specification);
                String spec = specification.getText().toString();
                EditText comments = (EditText) view.findViewById(R.id.comments);
                String comment = comments.getText().toString();

                String subject = "Add new place to Travel With Us";

                String address = "gowripratyusha28@gmail.com";

                String body = "Name of User: "+name;
                body += "\nName of Place: "+place;
                body += "\nSpecifications of place: "+spec;
                body += "\nComments: "+comment;
                composeEmail(address,subject,body);
            }
        });
        return view;
    }

    /**
     * For email intent
     * @param body
     * @param subject
     */
    public void composeEmail(String address, String subject,String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.putExtra(Intent.EXTRA_EMAIL,address);
        startActivity(intent);
    }

}
