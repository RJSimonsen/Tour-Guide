package com.example.android.exploreprincewilliamcounty;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ShoppingFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate (R.layout.attractions_list, container, false);
        //Creates the String Arrays for the colors list words with an ArrayList.
        final ArrayList<Attraction> attractions = new ArrayList<> ();
        attractions.add (new Attraction ("Puzzle Polooza Etc", "Two Locations", R.drawable.ic_pwc, "http://ppe.puzzlepaloozaetc.com/"));
        attractions.add (new Attraction ("Sweet Society", "Woodbridge", R.drawable.ic_pwc, "https://www.facebook.com/sweetsocietyptc/"));

        //Creates an array adapter to display the number words.
        AttractionAdapter adapter = new AttractionAdapter (getActivity (), attractions, R.color.category_shopping);
        ListView listView = rootView.findViewById (R.id.list);
        listView.setAdapter (adapter);
        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Attraction attraction = attractions.get (position);
            }
        });
        return rootView;
    }
}
