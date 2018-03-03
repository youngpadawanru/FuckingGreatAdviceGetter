package com.example.user.fuckinggreatadvicegetter;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface FGAClient {
    @GET("random")
    Single<Advice> getData(
    );
}