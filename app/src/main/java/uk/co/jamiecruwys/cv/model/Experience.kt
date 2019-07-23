package uk.co.jamiecruwys.cv.model

data class Experience(
    val id: Int?,
    val name: String?,
    val position: String?,
    val startDate: String?,
    val endDate: String?
) {
    override fun toString(): String {
        return "Experience: $name\n" +
                "Id: $id\n" +
                "Position: $position\n" +
                "Start Date: $startDate\n" +
                "End Date: $endDate\n"
    }
}