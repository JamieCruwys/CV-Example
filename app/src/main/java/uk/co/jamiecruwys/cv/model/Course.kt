package uk.co.jamiecruwys.cv.model

data class Course(
    val grade: String?,
    val location: String?,
    val name: String?
) {
    override fun toString(): String = "Course: $name\n" +
            "Grade: $grade\n" +
            "Location: $location\n"
}