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

    override fun showPersonalProject(title: String?, link: String?, features: String?) {
//        personal_projects_container.isVisible = true
//        personal_projects_item_container.isVisible = true
//
//        val view = inflater.inflate(R.layout.include_personal_project, personal_projects_item_container, false)
//        view.project_title.text = title
//
//        if (!link.isNullOrBlank()) {
//            view.project_link.isVisible = true
//            view.project_link.text = link
//        } else {
//            view.project_link.isVisible = false
//        }
//
//        if (!features.isNullOrBlank()) {
//            view.project_features.isVisible = true
//            view.project_features.text = features
//        } else {
//            view.project_features.isVisible = false
//        }
//
//        personal_projects_item_container.addView(view)
    }

    override fun hidePersonalProjects() {
//        personal_projects_item_container.removeAllViews()
//        personal_projects_container.isVisible = false
//        personal_projects_item_container.isVisible = false
    }

    override fun showExperience(experience: List<Experience>) {
        TODO("not implemented")
    }

    override fun hideExperience() {
        TODO("not implemented")
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