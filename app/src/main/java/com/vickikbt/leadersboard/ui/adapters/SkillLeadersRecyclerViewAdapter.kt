package com.vickikbt.leadersboard.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vickikbt.leadersboard.R
import com.vickikbt.leadersboard.model.SkillLeadersModel

class SkillLeadersRecyclerViewAdapter(
    private val context: Context,
    private val skillLeadersList: List<SkillLeadersModel>
) : RecyclerView.Adapter<SkillRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.skill_recyclerview_item, parent, false)
        return SkillRecyclerViewViewHolder(view)
    }

    override fun getItemCount() = 20//skillLeadersList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SkillRecyclerViewViewHolder, position: Int) {
        val leader = skillLeadersList[position]
        Glide.with(context).load(leader.badgeUrl).into(holder.badge)
        holder.userName.text = leader.name
        holder.skillCountry.text = "${leader.score.toString()} skill IQ Score, ${leader.country}"
    }
}

class SkillRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val badge: ImageView = itemView.findViewById(R.id.skill_badge_imageView)
    val userName: TextView = itemView.findViewById(R.id.skill_username_textView)
    val skillCountry: TextView = itemView.findViewById(R.id.skill_country_textView)
}