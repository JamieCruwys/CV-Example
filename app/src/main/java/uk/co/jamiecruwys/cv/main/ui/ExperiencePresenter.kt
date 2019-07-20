package uk.co.jamiecruwys.cv.main.ui

import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.main.CVRepository
import javax.inject.Inject

class ExperiencePresenter(val view: ExperienceView) {

    @Inject
    lateinit var cvRepository: CVRepository

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
    }

//    fun showPersonalProjects(personalProjects: List<Project?>?) {
//        val filteredProjects: List<Project> = personalProjects?.filterNotNull()?.filter { !it.name.isNullOrBlank() } ?: listOf()
//        if (filteredProjects.isNotEmpty()) {
//            filteredProjects.forEach {
//                val filteredFeatures: List<String> = it.features?.filterNotNull()?.filter { feature -> !feature.isBlank() } ?: listOf()
//                val stringBuilder = StringBuilder()
//                val lastIndex = filteredFeatures.lastIndex
//
//                filteredFeatures.forEachIndexed { index, feature ->
//                    stringBuilder.append("\u2022 $feature")
//
//                    if (lastIndex != -1 && index < lastIndex) {
//                        stringBuilder.append("\n")
//                    }
//                }
//
//                view?.showPersonalProject(it.name, it.link, stringBuilder.toString())
//            }
//        } else {
//            view?.hidePersonalProjects()
//        }
//    }
//
//    fun showEducation(education: List<Course?>?) {
//        val filteredEducation: List<Course> = education?.filterNotNull() ?: listOf()
//        if (filteredEducation.isNotEmpty()) {
//            view?.showEducation(filteredEducation)
//        } else {
//            view?.hideEducation()
//        }
//    }
//
//    fun showExperience(experience: List<Experience?>?) {
//        val filteredExperience: List<Experience> = experience?.filterNotNull() ?: listOf()
//        if (filteredExperience.isNotEmpty()) {
//            view?.showExperience(filteredExperience)
//        } else {
//            view?.hideExperience()
//        }
//    }

    fun onDestroy() {
    }
}