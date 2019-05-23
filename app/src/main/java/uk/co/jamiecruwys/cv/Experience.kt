package uk.co.jamiecruwys.cv

import uk.co.jamiecruwys.cv.api.Project

data class Experience(val company: String,
                      val position: String,
                      val startdate: String,
                      val enddate: String,
                      val skills: List<String>,
                      val projects: List<Project>)