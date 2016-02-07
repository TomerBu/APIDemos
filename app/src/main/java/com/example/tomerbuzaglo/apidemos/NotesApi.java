package com.example.tomerbuzaglo.apidemos;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public class NotesApi {
    public static final String API_URL = "https://apidem.herokuapp.com/";
    private final Retrofit retrofit;
    private final NotesService notesService;

    public NotesApi() {
        /*
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        OkHttpClient client = builder.build();
        new Retrofit.Builder().
                baseUrl(API_URL).client(client).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        */

        retrofit =
                new Retrofit.Builder().
                        baseUrl(API_URL).
                        addConverterFactory(GsonConverterFactory.create()).
                        build();
        // Create an instance of our GitHub API interface.
        notesService = retrofit.create(NotesService.class);
    }

    public interface NotesService {
        @GET("/api/notes")
        Call<Notes> notes(@Query("user") String user);

        // POST form encoded with form field params
        @FormUrlEncoded
        @POST("/api/notes")
        Call<Notes> addNote(@Field("title") String title, @Field("note") String note);

        // POST with a JSON body
        @POST("/post")
        Call<Notes> postWithJson(@Body Note note
        );
    }

    public void getAllNotes() throws IOException {
        // Create a call instance for looking up Retrofit contributors.
        Call<Notes> call = notesService.notes("tomer");
        call.enqueue(new Callback<Notes>() {
            @Override
            public void onResponse(Call<Notes> call, Response<Notes> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Notes> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void newNote() {
        Call<Notes> notesCall = notesService.addNote("Android", "Added thid note from");
        notesCall.enqueue(new Callback<Notes>() {
            @Override
            public void onResponse(Call<Notes> call, Response<Notes> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<Notes> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}