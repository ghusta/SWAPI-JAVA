package com.swapi;

import com.swapi.models.Film;
import com.swapi.models.Planet;
import com.swapi.models.SWModelList;
import com.swapi.sw.StarWars;
import com.swapi.sw.StarWarsApi;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SimpleTest {

    private StarWars api;

    @Before
    public void setUp() throws Exception {
        api = StarWarsApi.getApi();
    }

    @Test
    public void getAllFilms() throws Exception {
        Call<SWModelList<Film>> films = api.getAllFilms(1);

        Response<SWModelList<Film>> response = films.execute();
        if (response.isSuccessful()) {
            SWModelList<Film> data = response.body();
            int count = data.count;
            assertTrue(count > 0);
            for (Film film : data.results) {
                System.out.println(String.format("Episode %d - Title: %-25s (%s)", film.episodeId, film.title, film.releaseDate));
            }
        }
        else {
            System.err.println(response.code() + " - " + response.message());
            fail("Request failed");
        }
    }

    @Test
    public void getAllPlanets() throws Exception {
        Call<SWModelList<Planet>> planets = api.getAllPlanets(null);

        Response<SWModelList<Planet>> response = planets.execute();
        if (response.isSuccessful()) {
            SWModelList<Planet> data = response.body();
            int count = data.count;
            assertTrue(count > 0);
            for (Planet planet : data.results) {
                System.out.println(String.format("Name: %-25s Climate: %-25s Pop: %16s", planet.name, planet.climate, planet.population));
            }
        }
        else {
            System.err.println(response.code() + " - " + response.message());
            fail("Request failed");
        }
    }
}
