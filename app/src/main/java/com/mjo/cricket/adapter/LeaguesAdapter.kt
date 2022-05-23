package com.mjo.cricket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mjo.cricket.R

import com.mjo.cricket.databinding.ItemLeaguesCardBinding

class LeaguesAdapter(private val leaguesList: ArrayList<String>):RecyclerView.Adapter<LeaguesAdapter.LeaguesHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int){

        }
    }

    fun setOnItemClickListener(listener:OnItemClickListener){
        mListener = listener
    }


    class LeaguesHolder(item: View,listener: LeaguesAdapter.OnItemClickListener):RecyclerView.ViewHolder(item) {
        private val binding = ItemLeaguesCardBinding.bind(item)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
        fun bind(strLeague: String) =with(binding) {
            leagueTextView.text = strLeague
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_leagues_card,parent,false)
        return LeaguesHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: LeaguesHolder, position: Int) {
        holder.bind(leaguesList[position])
    }

    override fun getItemCount(): Int {
        return leaguesList.size
    }
}