package uk.co.jamiecruwys.cv

interface MainView {

    fun showLoading()

    fun hideLoading()

    fun showContent(content: MainContent)

    fun showError()
}