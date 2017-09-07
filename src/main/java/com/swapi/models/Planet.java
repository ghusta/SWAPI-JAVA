package com.swapi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Oleur on 22/12/2014.
 * Planet model represents a large mass, planet or planetoid in the Star Wars Universe, at the time of 0 ABY.
 */
public class Planet implements Serializable {
    public String name;
    public String diameter;
    public String gravity;
    public String population;
    public String climate;
    public String terrain;
    public String created;
    public String edited;
    public String url;

    @SerializedName("rotation_period")
    public String rotationPeriod;

    @SerializedName("orbital_period")
    public String orbitalPeriod;

    @SerializedName("surface_water")
    public String surfaceWater;

    @SerializedName("residents")
    public List<String> residentsUrls;

    @SerializedName("films")
    public List<String> filmsUrls;
}
