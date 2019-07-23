package uk.co.jamiecruwys.cv.model

data class Course(
    val name: String?,
    val grade: String?,
    val location: String?
) {
    override fun toString(): String = "Course: $name\n" +
            "Grade: $grade\n" +
            "Location: $location\n"
}