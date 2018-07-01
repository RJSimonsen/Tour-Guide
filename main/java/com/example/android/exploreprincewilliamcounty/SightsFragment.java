package com.example.android.exploreprincewilliamcounty;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class SightsFragment extends Fragment {

    /**
     * Handles the website viewing
     */
    private WebView mWebView;
    /**
     * Handles the website URL
     */
    private String mAttractionURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate (R.layout.attractions_list, container, false);

        //Creates the String Arrays for the sights with an ArrayList.
        final ArrayList<Attraction> attractions = new ArrayList<> ();
        attractions.add (new Attraction ((getString (R.string.sight1_name)), (getString (R.string.sight1_location)),
                R.drawable.ic_pnats, (getString (R.string.sight1_URL))));

        //Creates an array adapter to display the sights attractions.
        AttractionAdapter adapter = new AttractionAdapter (getActivity (), attractions, R.color.category_sights);
        ListView listView = rootView.findViewById (R.id.list);
        listView.setAdapter (adapter);

        // Set a click listener to go to URL list item is clicked on
        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link attraction} object at the given position the user clicked on
                Attraction attraction = attractions.get (position);

                // Create and setup the {@link WebView} for the web resource associated
                // with the current attraction
                mWebView = rootView.findViewById (R.id.attraction_website);
                // defines current attraction URL
                mAttractionURL = attraction.getAttractionURL ();
                Log.v ("attraction URL is", mAttractionURL);
                // displays URL
                mWebView.loadUrl(mAttractionURL);
            }
        });

        return rootView;
    }

}
