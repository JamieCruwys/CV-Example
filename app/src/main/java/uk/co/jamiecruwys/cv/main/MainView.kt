package uk.co.jamiecruwys.cv.main

import uk.co.jamiecruwys.cv.api.Profile

interface MainView {

    fun showLoading()

    fun hideLoading()

    fun showContent(content: Profile)

    fun showError()
}