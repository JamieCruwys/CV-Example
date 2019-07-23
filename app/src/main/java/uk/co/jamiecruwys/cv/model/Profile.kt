package uk.co.jamiecruwys.cv.model

data class Profile(
    val name: String? = null,
    val position: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val summary: String? = null,
    val community: String? = null,
    val education: List<Course?>? = null,
    val awards: List<Award?>? = null,
    val experiences: List<Experience?>? = null,
    val projects: List<Project?>? = null
) {
    override fun toString(): String = "Profile: $name\n" +
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