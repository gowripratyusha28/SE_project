package com.androidtutorialshub.loginregister.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.model.Userfeedback;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;
import com.androidtutorialshub.loginregister.sql.FeedbackHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedbackFragment#} factory method to
 * create an instance of this fragment.
 */
public class FeedbackFragment extends Fragment {

    private Spinner mPlaceSpinner;
    private String mPlace;

    private FeedbackHelper feedbackHelper;
    private Userfeedback userfeedback;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        mPlaceSpinner = (Spinner) view.findViewById(R.id.spinner_place);
        setupSpinner();
        Button btn =(Button) view.findViewById(R.id.submit_feedback);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText feedbackaboutplace = (EditText) view.findViewById(R.id.feedback_about_place);
                String feedback1 = feedbackaboutplace.getText().toString();
                EditText generalfeedback = (EditText) view.findViewById(R.id.general_feedback);
                String feedback2 = generalfeedback.getText().toString();

                feedbackHelper = new FeedbackHelper(getContext());
                userfeedback = new Userfeedback();
                userfeedback.setName(RegisterActivity.name);
                userfeedback.setPlacename(mPlace);
                userfeedback.setPlacefeedback(feedback1);
                userfeedback.setPlacefeedback(feedback2);
                Toast toastmessage = Toast.makeText(getContext(),"Feedback submitted successfully",Toast.LENGTH_SHORT);
                feedbackHelper.addUserfeedback(userfeedback);
                feedbackaboutplace.setText(null);
                generalfeedback.setText(null);
            }
        });
        return view;
    }

    /**
     * Setup the dropdown spinner that allows the user to select the gender of the pet.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter categorySpinnerAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.place_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mPlaceSpinner.setAdapter(categorySpinnerAdapter);

        // Set the integer mSelected to the constant values
        mPlaceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                mPlace = selection;
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                mPlace = "R.K.Beach";
            }
        });
    }

}
