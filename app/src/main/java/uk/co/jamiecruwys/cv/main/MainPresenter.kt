package uk.co.jamiecruwys.cv.main

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uk.co.jamiecruwys.cv.App
import uk.co.jamiecruwys.cv.api.ApiService
import uk.co.jamiecruwys.cv.api.Course
import uk.co.jamiecruwys.cv.api.Experience
import uk.co.jamiecruwys.cv.api.Profile
import uk.co.jamiecruwys.cv.api.Project
import javax.inject.Inject

class MainPresenter(val view: MainView?) {

    @Inject
    lateinit var apiService: ApiService

    init {
        App.appComponent.inject(this)
    }

    fun onResume() {
        view?.showLoading()
        apiService.getProfileJson().enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                view?.hideLoading()
                val dto = response.body()
                dto?.let {
                    showName(dto.name)
                    showPosition(dto.position)
                    showContactInfoContainer(dto.phone, dto.email)
                    showPhone(dto.phone)
                    showEmail(dto.email)
                    showSummary(dto.summary)
                    showCommunity(dto.community)
                    showPersonalProjects(dto.personalProjects)
                    showEducation(dto.education)
                    showExperience(dto.experience)
                } ?: view?.showError()
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                view?.hideLoading()
                view?.showError()
            }
        })
    }

    fun showName(name: String?) {
        if (!name.isNullOrEmpty()) {
            view?.showName(name)
        } else {
            view?.hideName()
        }
    }

    fun showPosition(position: String?) {
        if (!position.isNullOrEmpty()) {
            view?.showPosition(position)
        } else {
            view?.hidePosition()
        }
    }

    fun showContactInfoContainer(phone: String?, email: String?) {
        if (!phone.isNullOrEmpty() && !email.isNullOrEmpty()) {
            view?.showContactInfoContainer()
        } else {
            view?.hideContactInfoContainer()
        }
    }

    fun showPhone(phone: String?) {
        if (!phone.isNullOrEmpty()) {
            view?.showPhone(phone)
        } else {
            view?.hidePhone()
        }
    }

    fun showEmail(email: String?) {
        if (!email.isNullOrEmpty()) {
            view?.showEmail(email)
        } else {
            view?.hideEmail()
        }
    }

    fun showSummary(summary: String?) {
        if (!summary.isNullOrEmpty()) {
            view?.showSummary(summary)
        } else {
            view?.hideSummary()
        }
    }

    fun showCommunity(community: String?) {
        if (!community.isNullOrEmpty()) {
            view?.showCommunity(community)
        } else {
            view?.hideCommunity()
        }
    }

    fun showPersonalProjects(personalProjects: List<Project?>?) {
        val filteredProjects: List<Project> = personalProjects?.filterNotNull() ?: listOf()
        if (filteredProjects.isNotEmpty()) {
            view?.showPersonalProjects(filteredProjects)
        } else {
            view?.hidePersonalProjects()
        }
    }

    fun showEducation(education: List<Course?>?) {
        val filteredEducation: List<Course> = education?.filterNotNull() ?: listOf()
        if (filteredEducation.isNotEmpty()) {
            view?.showEducation(filteredEducation)
        } else {
            view?.hideEducation()
        }
    }

    fun showExperience(experience: List<Experience?>?) {
        val filteredExperience: List<Experience> = experience?.filterNotNull() ?: listOf()
        if (filteredExperience.isNotEmpty()) {
            view?.showExperience(filteredExperience)
        } else {
            view?.hideExperience()
        }
    }

    fun onDestroy() {
    }
}