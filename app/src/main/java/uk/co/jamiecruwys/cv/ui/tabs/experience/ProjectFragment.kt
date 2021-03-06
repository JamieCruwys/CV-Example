package uk.co.jamiecruwys.cv.ui.tabs.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_experience.*
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.R
import uk.co.jamiecruwys.cv.model.Project
import javax.inject.Inject

class ProjectFragment : Fragment(), ProjectView {

    @Inject
    lateinit var presenter: ProjectPresenter

    private val adapter: ProjectsAdapter = ProjectsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        projects.layoutManager = LinearLayoutManager(context)
        projects.adapter = adapter
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

    override fun showProjects(projects: List<Project>) {
        adapter.setItems(projects)
    }

    override fun hideProjects() {
        adapter.clearItems()
    }

    companion object {
        @JvmStatic
        fun newInstance(): ProjectFragment = ProjectFragment()
    }
}