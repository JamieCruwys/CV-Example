package uk.co.jamiecruwys.cv.main.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uk.co.jamiecruwys.cv.R

class ExperienceFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(): ExperienceFragment = ExperienceFragment()
    }
}