package uk.co.jamiecruwys.cv.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.R
import uk.co.jamiecruwys.cv.api.Experience

class ExperienceFragment : Fragment(), ExperienceView {

    private lateinit var presenter: ExperiencePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        presenter = ExperiencePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isVisible && isResumed) {
            presenter.onResume()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun showExperience(experience: List<Experience>) {
        // TODO:
    }

    override fun hideExperience() {
        // TODO:
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance(): ExperienceFragment =
            ExperienceFragment()
    }
}