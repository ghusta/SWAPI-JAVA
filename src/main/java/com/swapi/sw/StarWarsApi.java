package com.swapi.sw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.swapi.APIConstants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oleur on 22/12/2014.
 * The Star Wars Api class
 */
public class StarWarsApi {

    private static final Logger log = LoggerFactory.getLogger(StarWarsApi.class);

    private StarWars swService;
    private static StarWarsApi instance;

    private StarWarsApi() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new RequestLoggingInterceptor());

        // TODO: add header User-Agent

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper().registerModule(new JodaModule())))
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

    private static class RequestLoggingInterceptor implements Interceptor
    {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            log.debug("HTTP Request : {}", request.toString());
            log.debug("HTTP Request headers : {}", request.headers().toString());

            Response response = chain.proceed(request);
            return response;
        }
    }

}
