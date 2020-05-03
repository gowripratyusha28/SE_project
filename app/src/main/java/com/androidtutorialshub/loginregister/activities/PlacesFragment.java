package com.androidtutorialshub.loginregister.activities;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;

import java.util.ArrayList;

import static com.androidtutorialshub.loginregister.R.layout.activity_place1;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment {

    public static int number;

    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("R.K.Beach",  R.drawable.rk1));
        words.add(new Word("Simhachalam",  R.drawable.simhachalam2));
        words.add(new Word("Yarada Beach",  R.drawable.yarada1));
        words.add(new Word("Kailasgiri Hill Park",  R.drawable.kh1));
        words.add(new Word("Kamabalakonda sanctuary",  R.drawable.kws2));
        words.add(new Word("Indira Gandhi Zoological Park",  R.drawable.ig1));
        words.add(new Word("Rushikonda Beach",R.drawable.rushi1));
        words.add(new Word("Vuda Park",R.drawable.vuda1));
        words.add(new Word("City Central Park",R.drawable.ccp2));
        words.add(new Word("CMR Central",R.drawable.cmr1));
        words.add(new Word("Air Craft Museum",R.drawable.air1));
        words.add(new Word("Dolphins Nose",R.drawable.dol2));
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        GridView listView = (GridView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file

                Intent intent = new Intent(getContext(),Place1Activity.class);
                startActivity(intent);
                number = position;

            }
        });

        return rootView;
    }

}
