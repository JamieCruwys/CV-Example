package uk.co.jamiecruwys.cv.api

data class Experience(
    val id: Int?,
    val name: String?,
    val position: String?,
    val startDate: String?,
    val endDate: String?
) {
    override fun toString(): String {
        return "Id: $id\n" +
                "Name: $name\n" +
                "Position: $position\n" +
                "Start Date: $startDate\n" +
                "End Date: $endDate\n"
    }
}