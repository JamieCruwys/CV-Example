package uk.co.jamiecruwys.cv.api

data class Project(
    val name: String?,
    val subtitle: String?,
    val link: String?,
    val description: String?,
    val experienceId: Int?
) {
    override fun toString(): String = "Project: $name\n" +
            "Subtitle: $subtitle\n" +
            "Link: $link\n" +
            "Description: $description\n" +
            "ExperienceId: $experienceId"
}