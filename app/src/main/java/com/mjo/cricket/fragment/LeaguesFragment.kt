package com.mjo.cricket.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjo.cricket.R
import com.mjo.cricket.RetrofitInstance
import com.mjo.cricket.converter.convertToСricketLeagueList
import com.mjo.cricket.adapter.LeaguesAdapter
import com.mjo.cricket.adapter.TeamsAdapter
import com.mjo.cricket.data.leagues.Leagues
import com.mjo.cricket.databinding.FragmentLeaguesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaguesFragment : Fragment() {
    private var _binding:FragmentLeaguesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getDataOfLeagues()
        _binding = FragmentLeaguesBinding.inflate(inflater,container,false)
        return  binding.root
    }


    private fun getDataOfLeagues(){
        RetrofitInstance.api.getLeaguesList().enqueue(object: Callback<Leagues> {

            override fun onFailure(call: Call<Leagues>, t: Throwable) {
                Log.e("ERROR","$t")
                Toast.makeText(Activity().applicationContext,"Oops! Something went wrong", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Leagues>,
                response: Response<Leagues>
            ) {
                if (!response.isSuccessful){
                    Toast.makeText(Activity().applicationContext,"Oops! Something went wrong", Toast.LENGTH_SHORT).show()
                }
                val converter: convertToСricketLeagueList = convertToСricketLeagueList(response.body()!!)
                var  strList = converter.convertToList()
               binding.rcView.layoutManager = LinearLayoutManager(activity!!.applicationContext)

                var adapter =  LeaguesAdapter(strList as ArrayList<String>)
                binding.rcView.adapter = adapter
                adapter.setOnItemClickListener(object : LeaguesAdapter.OnItemClickListener{
                    override fun onItemClick(position: Int) {
                        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment, TeamsFragment(strList[position])).addToBackStack(null).commit()
                    }
                })

            }

        })
    }
}