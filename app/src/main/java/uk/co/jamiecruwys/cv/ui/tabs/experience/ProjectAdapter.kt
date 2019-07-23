package uk.co.jamiecruwys.cv.ui.tabs.experience

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_project.view.*
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Project
import uk.co.jamiecruwys.cv.repository.ProfileRepository
import javax.inject.Inject
import android.view.LayoutInflater
import android.content.Intent
import android.net.Uri
import uk.co.jamiecruwys.cv.R

class ProjectsAdapter : RecyclerView.Adapter<ProjectViewHolder>() {

    @Inject
    lateinit var cvRepository: ProfileRepository

    private val projects: ArrayList<Project> = ArrayList()

    init {
        App.appComponent.inject(this)
    }

    fun setItems(newProjects: List<Project>) {
        clearItems()
        projects.addAll(newProjects)
        notifyDataSetChanged()
    }

    fun clearItems() {
        projects.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)
        return ProjectViewHolder(view)
    }

    override fun getItemCount(): Int = projects.size

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projects[position]
        val experience = cvRepository.get()?.experiences?.find {
            it?.id == project.experienceId
        }

        holder.show(projects[position], experience)
    }
}

class ProjectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun show(project: Project, experience: Experience?) {
        val validSubtitle = !project.subtitle.isNullOrEmpty()
        itemView.title.text = if (validSubtitle) "${project.name} - ${project.subtitle}" else project.name

        val validLink = !project.link.isNullOrEmpty()
        itemView.link.isVisible = validLink
        if (validLink) {
            itemView.link.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(project.link))
                val resolvedActivity = intent.resolveActivity(itemView.context.packageManager)
                if (resolvedActivity != null) {
                    itemView.context.startActivity(intent)
                }
            }
        } else {
            itemView.link.setOnClickListener(null)
        }

        val validDescription = !project.description.isNullOrEmpty()
        itemView.description.isVisible = validDescription
        itemView.description.text = if (validDescription) project.description else ""

        val validExperience = !experience?.name.isNullOrEmpty()
        itemView.experience.isVisible = validExperience
        itemView.experience.text = if (validExperience) experience?.name else ""
    }
}