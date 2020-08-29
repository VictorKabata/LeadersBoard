package com.vickikbt.leadersboard.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vickikbt.leadersboard.ui.fragments.HoursLeadersFragment
import com.vickikbt.leadersboard.ui.fragments.SkillLeadersFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HoursLeadersFragment()
            else -> SkillLeadersFragment()
        }
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Learning Leaders"
            else -> "Skill IQ Leaders"
        }
    }


}