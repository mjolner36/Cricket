package com.mjo.cricket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjo.cricket.R
import com.mjo.cricket.adapter.TeamsAdapter
import com.mjo.cricket.data.teams.Team
import com.mjo.cricket.databinding.FragmentTeamInfoBinding
import com.mjo.cricket.databinding.FragmentTeamsBinding


class TeamInfoFragment(team:Team) : Fragment() {
    private var _binding: FragmentTeamInfoBinding? = null
    private val binding get() = _binding!!

    var tempTeam = team

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.country.text = tempTeam.strCountry
        binding.formedYear.text = tempTeam.intFormedYear
        binding.instagram.text = tempTeam.strInstagram
        binding.youtube.text = tempTeam.strYoutube
        binding.facebook.text = tempTeam.strFacebook
        binding.gender.text = tempTeam.strGender
        _binding = FragmentTeamInfoBinding.inflate(inflater,container,false)
        return  binding.root
    }

}