package com.swapi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Oleur on 21/12/2014.
 * Film model represents a Star Wars single film.
 */
public class Film implements Serializable {

    public String title;

    @SerializedName("episode_id")
    public int episodeId;

    @SerializedName("opening_crawl")
    public String openingCrawl;

    public String director;
    public String producer;
    public String url;
    public String created;
    public String edited;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("species")
    public List<String> speciesUrls;

    @SerializedName("starships")
    public List<String> starshipsUrls;

    @SerializedName("vehicles")
    public List<String> vehiclesUrls;

    @SerializedName("planets")
    public List<String> planetsUrls;

    @SerializedName("characters")
    public List<String> charactersUrls;
}
