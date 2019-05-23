package uk.co.jamiecruwys.cv.api

data class Project(
    val name: String,
    val link: String,
    val features: List<String>
) {
    override fun toString(): String = "Project: $name\n" +
            "Link: $link\n" +
            "Features: $features\n"
}