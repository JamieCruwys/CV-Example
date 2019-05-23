package uk.co.jamiecruwys.cv.api

data class Award(val name: String?) {
    override fun toString(): String = "Award: $name\n"
}