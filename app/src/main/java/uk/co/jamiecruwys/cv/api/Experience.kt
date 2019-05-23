package uk.co.jamiecruwys.cv.api

data class Experience(val company: String,
                      val position: String,
                      val startDate: String,
                      val endDate: String,
                      val skills: List<String>,
                      val projects: List<Project>)