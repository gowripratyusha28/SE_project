package com.androidtutorialshub.loginregister.activities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.androidtutorialshub.loginregister.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment {

    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Araku Valley",  R.drawable.aruku));
        words.add(new Word("Borra Caves",  R.drawable.logo));
        words.add(new Word("Simhachalam temple",  R.drawable.logo));
        words.add(new Word("Yarada Beach",  R.drawable.logo));
        words.add(new Word("Kailasgiri Hill Park",  R.drawable.logo));
        words.add(new Word("Kamabalakonda sanctuary",  R.drawable.logo));
        words.add(new Word("R.K.Beach",  R.drawable.logo));
        words.add(new Word("Indira Gandhi Zoological Park",  R.drawable.logo));
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

            }
        });

        return rootView;
    }

}
