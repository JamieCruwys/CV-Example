package uk.co.jamiecruwys.cv.main.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uk.co.jamiecruwys.cv.R

private val TAB_TITLES = arrayOf(
    R.string.tab_summary,
    R.string.tab_experience
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SummaryFragment.newInstance()
            else -> ExperienceFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}