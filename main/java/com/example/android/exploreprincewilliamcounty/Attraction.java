package com.example.android.exploreprincewilliamcounty;


/**
 * {@Link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation, and Miwok audio file for each word.
 */
public class Attraction {
    /**
     * Name of the attraction.
     */
    private String mAttractionName;
    /**
     * Location of the attraction.
     */
    private String mAttractionLocation;
    /**
     * Resource id for the attraction image.
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /*This helps determine if there is an image provided. setVisibility can only be 0, 6, and 8.
     * So a value of -1 must mean that there is no image */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Website of the attraction.
     */
    private String mAttractionUrl;

    /**
     * Creates new attraction object for constructors with 3 Strings and 1 int inputs.
     *
     * @param attractionName     This is name of the attraction.
     * @param attractionLocation This is the area in the county where the attraction is located.
     * @param imageResourceId    This is the pointer to the image that matches the word.
     * @param attractionURL      This is the Website of the attraction
     */
    public Attraction(String attractionName, String attractionLocation, int imageResourceId, String attractionURL) {
        mAttractionName = attractionName;
        mAttractionLocation = attractionLocation;
        mImageResourceId = imageResourceId;
        mAttractionUrl = attractionURL;
    }

    /**
     * Returns whather of not the attraction has an image.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    //Gets the name of the attraction
    public String getAttractionName() {
        return mAttractionName;
    }

    //Gets the location of the attraction
    public String getAttractionLocation() {
        return mAttractionLocation;
    }

    //Gets the image for the attraction.
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //Gets the URL of the attraction
    public String getAttractionURL() {
        return mAttractionUrl;
    }
}
