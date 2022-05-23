package com.mjo.cricket

import com.mjo.cricket.data.leagues.Leagues
import com.mjo.cricket.data.teams.ListAllTeams
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface СricketApi {

    @GET("./all_leagues.php")
    fun getLeaguesList(): Call<Leagues>

    @GET("./search_all_teams.php")  // update for team which user will clicked
    fun getTeamsFromLeague(@Query("l") league: String): Call<ListAllTeams>



}


object RetrofitInstance {
    var api = Retrofit.Builder()
        .baseUrl("https://www.thesportsdb.com/api/v1/json/2/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(СricketApi::class.java)
}