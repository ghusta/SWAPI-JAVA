package com.swapi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Oleur on 21/12/2014.
 * People model represents an individual person or character within the Star Wars universe.
 */
public class People implements Serializable {
    public String name;

    @SerializedName("birth_year")
    public String birthYear;

    @SerializedName("films")
    public List<String> filmsUrls;

    public String gender;

    @SerializedName("hair_color")
    public String hairColor;

    public String height;

    @SerializedName("homeworld")
    public String homeWorldUrl;

    public String mass;

    @SerializedName("skin_color")
    public String skinColor;

    public String created;
    public String edited;
    public String url;

    @SerializedName("species")
    public List<String> speciesUrls;

    @SerializedName("starships")
    public List<String> starshipsUrls;

    @SerializedName("vehicles")
    public List<String> vehiclesUrls;
}
