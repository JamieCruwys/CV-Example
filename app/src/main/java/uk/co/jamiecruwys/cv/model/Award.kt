package uk.co.jamiecruwys.cv.model

data class Award(val name: String?) {
    override fun toString(): String = "Award: $name\n"
}