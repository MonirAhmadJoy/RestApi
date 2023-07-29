package com.example.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApiService {
    @GET("volumes")
    Call<BookApiResponse> searchBooks(@Query("q") String query);
}

