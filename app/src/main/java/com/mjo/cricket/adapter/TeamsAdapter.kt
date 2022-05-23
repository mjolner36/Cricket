package com.mjo.cricket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mjo.cricket.R
import com.mjo.cricket.data.teams.ListAllTeams
import com.mjo.cricket.data.teams.Team

import com.mjo.cricket.databinding.ItemTeamsCardBinding
import com.squareup.picasso.Picasso




class TeamsAdapter(private val body: ListAllTeams):RecyclerView.Adapter<TeamsAdapter.TeamsHolder>(){

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int){

        }
    }

    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener = listener
    }


    var teams = body.teams
    class TeamsHolder(item:View,listener: OnItemClickListener):RecyclerView.ViewHolder(item) {
        private val binding = ItemTeamsCardBinding.bind(item)

    init {
        itemView.setOnClickListener{
            listener.onItemClick(adapterPosition)
        }
    }

        fun bind(team: Team) =with(binding) {
            teamTextView.text = team.strTeam
            Picasso.get()
                .load(team.strTeamBanner)
                .into(banner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teams_card,parent,false)
        return TeamsHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: TeamsHolder, position: Int) {
        holder.bind(teams[position])
    }

    override fun getItemCount(): Int {
        return teams.size
    }


}