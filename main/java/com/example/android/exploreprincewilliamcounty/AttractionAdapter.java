package com.example.android.exploreprincewilliamcounty;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    /**
     * Resource ID for the background color for the list word.
     */
    private int mColorResourceID;

    public AttractionAdapter(Activity context, ArrayList<Attraction> words, int colorResourceID) {
        super (context, 0, words);
        mColorResourceID = colorResourceID;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from (getContext ()).inflate
                    (R.layout.list_item, parent, false);
        }

        // Get the {@link currentAttraction} object located at this position in the list
        Attraction currentAttraction = getItem (position);

        // Find the TextView in the list_item.xml layout with the ID attraction_name_textview
        TextView nameTextView = listItemView.findViewById (R.id.attraction_name_textview);
        // Get the attraction name from the current object and set this text on the nameTextView
        nameTextView.setText (currentAttraction.getAttractionName ());

        // Find the TextView in the list_item.xml layout with the ID attraction_location_textview
        TextView locationTextView = listItemView.findViewById (R.id.attraction_location_textview);
        // Get the attraction location from the current object and set this text on the locationTextView
        locationTextView.setText (currentAttraction.getAttractionLocation ());

        // Find the ImageView in the list_item.xml layout with the ID image_view
        ImageView imageView = listItemView.findViewById (R.id.image_view);
        //Determines if current object has an image.
        if (currentAttraction.hasImage ()) {
            // Get the image resource ID from the current Attraction object and
            // set the image to iconView
            imageView.setImageResource (currentAttraction.getImageResourceId ());
            //Makes sure the image is visible.
            imageView.setVisibility (View.VISIBLE);
        } else {
            //Makes the image gone
            imageView.setVisibility (View.GONE);
        }
        //Set the theme color for the list item
        View textContainer = listItemView.findViewById (R.id.text_container);
        //finds the color the resource ID maps to
        int color = ContextCompat.getColor (getContext (), mColorResourceID);
        //sets the background color for the text_container view.
        textContainer.setBackgroundColor (color);

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }

}

