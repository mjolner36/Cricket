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
import com.mjo.cricket.adapter.TeamsAdapter
import com.mjo.cricket.data.teams.ListAllTeams
import com.mjo.cricket.data.teams.Team
import com.mjo.cricket.databinding.FragmentTeamsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class TeamsFragment(league: String) : Fragment() {
    private var _binding: FragmentTeamsBinding? = null
    private val binding get() = _binding!!
    var tempLeague = league
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getTeamsFromLeague(tempLeague)
        _binding = FragmentTeamsBinding.inflate(inflater,container,false)
        return  binding.root
    }


    private fun getTeamsFromLeague(league: String){
        RetrofitInstance.api.getTeamsFromLeague(league).enqueue(object: Callback<ListAllTeams> {

            override fun onResponse(
                call: Call<ListAllTeams>, response: Response<ListAllTeams>) {
                if (!response.isSuccessful){
                    Toast.makeText(Activity().applicationContext,"Oops! Something went wrong", Toast.LENGTH_SHORT).show()
                }

                binding.rcView.layoutManager = LinearLayoutManager(activity!!.applicationContext)

                var adapter =  TeamsAdapter(response.body()!!)
                binding.rcView.adapter = adapter
                adapter.setOnItemClickListener(object : TeamsAdapter.OnItemClickListener{
                    override fun onItemClick(position: Int) {
                        activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment, TeamInformationFragment("vvvvvvvv")).addToBackStack(null).commit()
                        } //TeamInfoFragment(response.body()!!.teams[position]))
                    })
            }

            override fun onFailure(call: Call<ListAllTeams>, t: Throwable) {
                Log.e("ERROR","$t")
                Toast.makeText(Activity().applicationContext,"Oops! Something went wrong", Toast.LENGTH_SHORT).show()
            }

        })
    }
}