package uk.co.jamiecruwys.cv.api

data class Experience(
    val company: String?,
    val position: String?,
    val startDate: String?,
    val endDate: String?,
    val skills: List<String?>,
    val projects: List<Project?>?
) {
    override fun toString(): String = "Company: $company\n" +
            "Position: $position\n" +
            "Start Date: $startDate\n" +
            "End Date: $endDate\n" +
            "Skills: $skills\n" +
            "Projects: $projects\n"
}