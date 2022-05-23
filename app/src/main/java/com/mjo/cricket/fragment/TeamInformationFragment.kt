package com.mjo.cricket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjo.cricket.R
import com.mjo.cricket.data.teams.Team
import com.mjo.cricket.databinding.FragmentTeamInfomationBinding


class TeamInformationFragment(team:String) : Fragment() {

    private var _binding:FragmentTeamInfomationBinding? = null
    private val binding get() = _binding!!
    var tempTeam = team
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.country.text = tempTeam
        _binding = FragmentTeamInfomationBinding.inflate(inflater,container,false)
        return  binding.root
    }


}