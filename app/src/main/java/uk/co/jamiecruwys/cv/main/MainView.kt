package uk.co.jamiecruwys.cv.main

import uk.co.jamiecruwys.cv.api.CVDto

interface MainView {

    fun showLoading()

    fun hideLoading()

    fun showContent(content: CVDto)

    fun showError()
}