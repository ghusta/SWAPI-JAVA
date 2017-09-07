package com.swapi;

import com.swapi.models.Film;
import com.swapi.models.SWModelList;
import com.swapi.sw.StarWars;
import com.swapi.sw.StarWarsApi;
import org.junit.Before;
import org.junit.Test;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SimpleTest {

    private StarWars api;

    @Before
    public void setUp() throws Exception {
        StarWarsApi.init();
        api = StarWarsApi.getApi();
    }

    @Test
    public void getAllFilms() throws Exception {
        api.getAllFilms(1, new Callback<SWModelList<Film>>() {

            public void success(SWModelList<Film> filmSWModelList, Response response) {
                System.out.println("Count:"+ filmSWModelList.count);
                for(Film f : filmSWModelList.results) {
                    System.out.println("Title:" + f.title);
                }
            }

            public void failure(RetrofitError error) {

            }
        });
    }

}
