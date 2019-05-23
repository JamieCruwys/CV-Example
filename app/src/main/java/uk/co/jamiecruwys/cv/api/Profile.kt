package uk.co.jamiecruwys.cv.api

data class Profile(
    val name: String?,
    val position: String?,
    val phone: String?,
    val email: String?,
    val summary: String?,
    val community: String?,
    val personalProjects: List<Project?>?,
    val education: List<Course?>?,
    val awards: List<Award?>?,
    val experience: List<Experience?>?
) {
    override fun toString(): String = "Name: $name\n" +
            "Position: $position\n" +
            "Phone: $phone\n" +
            "Email: $email\n" +
            "Summary: $summary\n" +
            "Community: $community\n" +
            "Personal Projects: $personalProjects\n" +
            "Education: $education\n" +
            "Awards: $awards\n" +
            "Experience: $experience"
}