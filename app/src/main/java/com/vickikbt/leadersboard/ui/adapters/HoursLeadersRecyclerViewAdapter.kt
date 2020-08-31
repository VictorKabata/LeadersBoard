package com.vickikbt.leadersboard.ui.adapters

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
import com.vickikbt.leadersboard.util.log
import com.vickikbt.leadersboard.util.toast

class HoursLeadersRecyclerViewAdapter(
    private val context: Context,
    private val hoursLeaders: List<HoursLeaderModel>
) :
    RecyclerView.Adapter<HoursLeadersRecyclerViewAdapter.HoursLeadersRecyclerViewViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HoursLeadersRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hours_recyclerview_item, parent, false)

        return HoursLeadersRecyclerViewViewHolder(view)
    }

    override fun getItemCount() = hoursLeaders.size

    override fun onBindViewHolder(holder: HoursLeadersRecyclerViewViewHolder, position: Int) {
        val dataset = hoursLeaders[position]
        context.applicationContext.log("ItemCount: ${hoursLeaders.size}")
        context.applicationContext.log(dataset.toString())
        context.applicationContext.toast("Hello, World")

        holder.userName.text = dataset.name
        holder.hoursCountry.text = "${dataset.hours}, ${dataset.country}"

        Glide.with(context).load(dataset.badgeUrl).into(holder.badge)

    }

    class HoursLeadersRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val badge: ImageView = itemView.findViewById(R.id.badge_imageView)
        val userName: TextView = itemView.findViewById(R.id.username_textView)
        val hoursCountry: TextView = itemView.findViewById(R.id.hours_country_textView)
    }
}