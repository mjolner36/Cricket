package com.mjo.cricket.converter

import com.mjo.cricket.data.leagues.Leagues

class convertToСricketLeagueList(private val leagues: Leagues) {
    var size:Int =  leagues.leagues.size

    fun convertToList(): MutableList<String>{
        var list = mutableListOf<String>()
        for (item in 0 until size){
            if (leagues.leagues[item].strSport == "Cricket"){
                list.add(leagues.leagues[item].strLeague)
            }
        }
        return list
    }
}