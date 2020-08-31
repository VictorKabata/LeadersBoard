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
import com.vickikbt.leadersboard.model.HoursLeaderModel

class HoursLeadersRecyclerViewAdapter(
    private val context: Context,
    private val hoursLeadersList: List<HoursLeaderModel>
) : RecyclerView.Adapter<HoursLeadersRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HoursLeadersRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hours_recyclerview_item, parent, false)
        return HoursLeadersRecyclerViewViewHolder(view)
    }

    //TODO: Fix this later.
    override fun getItemCount() = 20//hoursLeadersList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HoursLeadersRecyclerViewViewHolder, position: Int) {
        val leader = hoursLeadersList[position]

        Glide.with(context).load(leader.badgeUrl).into(holder.badge)
        holder.userName.text = leader.name
        holder.skillCountry.text = "${leader.hours} learning hours, ${leader.country}"
    }
}

class HoursLeadersRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val badge: ImageView = itemView.findViewById(R.id.badge_imageView)
    val userName: TextView = itemView.findViewById(R.id.username_textView)
    val skillCountry: TextView = itemView.findViewById(R.id.hours_country_textView)
}