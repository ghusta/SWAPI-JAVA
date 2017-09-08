package com.swapi.sw;

import com.swapi.APIConstants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Oleur on 22/12/2014.
 * The Star Wars Api class
 */
public class StarWarsApi {

    private StarWars swService;
    private static StarWarsApi instance;

    private StarWarsApi() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        // TODO: add header User-Agent

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        swService = retrofit.create(StarWars.class);
    }

    public static StarWars getApi() {
        if (instance == null) {
            instance = new StarWarsApi();
        }
        return instance.swService;
    }

}
