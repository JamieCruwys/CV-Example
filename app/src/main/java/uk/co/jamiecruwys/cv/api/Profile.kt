package uk.co.jamiecruwys.cv.api

data class Profile(
    val name: String?,
    val position: String?,
    val phone: String?,
    val email: String?,
    val summary: String?,
    val community: String?,
    val education: List<Course?>?,
    val awards: List<Award?>?,
    val experiences: List<Experience?>?,
    val projects: List<Project?>?
) {
    override fun toString(): String = "Name: $name\n" +
            "Position: $position\n" +
            "Phone: $phone\n" +
            "Email: $email\n" +
            "Summary: $summary\n" +
            "Community: $community\n" +
            "Education: $education\n" +
            "Awards: $awards\n" +
            "Experiences: ${experiences?.size ?: 0}\n" +
            "Projects: ${projects?.size ?: 0}"
}