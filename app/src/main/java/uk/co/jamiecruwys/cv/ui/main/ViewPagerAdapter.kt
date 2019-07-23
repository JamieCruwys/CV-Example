package uk.co.jamiecruwys.cv.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uk.co.jamiecruwys.cv.R
import uk.co.jamiecruwys.cv.ui.tabs.summary.SummaryFragment
import uk.co.jamiecruwys.cv.ui.tabs.experience.ProjectFragment

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SummaryFragment.newInstance()
            1 -> ProjectFragment.newInstance()
            else -> throw IllegalStateException("Unknown view pager position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

    companion object {
        private val TAB_TITLES = arrayOf(
            R.string.tab_summary,
            R.string.tab_experience
        )
    }
}