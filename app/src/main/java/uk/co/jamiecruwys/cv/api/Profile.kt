package uk.co.jamiecruwys.cv.api

import uk.co.jamiecruwys.cv.Experience

data class Profile(val name: String,
                   val position: String,
                   val phone: String,
                   val email: String,
                   val summary: String,
                   val community: String,
                   val personalprojects: List<Project>,
                   val education: List<Course>,
                   val awards: List<Award>,
                   val experience: List<Experience>)