package uk.co.jamiecruwys.cv.repository

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import uk.co.jamiecruwys.cv.model.Award
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class ProfileRepositoryTest {

    private lateinit var repository: ProfileRepository

    @Before
    fun setUp() {
        repository = ProfileRepository()
    }

    @Test
    fun `given initial load, when retrieving profile, then return null`() {
        // Given

        // When
        val profile = repository.get()

        // Then
        Assert.assertEquals(null, profile)
    }

    @Test
    fun `given initial load, when saving profile, then profile saved`() {
        // Given

        // When
        repository.save(dummyProfile)

        // Then
        Assert.assertEquals(dummyProfile, repository.get())
    }

    @Test
    fun `given already has saved profile, when saving profile, then profile overridden`() {
        // Given
        repository.save(dummyProfile.copy(name = "John Doe", email = "test@test.com"))

        // When
        repository.save(dummyProfile)

        // Then
        Assert.assertEquals(dummyProfile, repository.get())
    }

    companion object {
        private val dummyProfile: Profile = Profile(
            "Name",
            "Position",
            "Phone",
            "Email",
            "Summary",
            "Community",
            listOf(Course("Grade", "Location", "Name")),
            listOf(Award("Name")),
            listOf(Experience(1, "Name", "Position", "01/01/2001", "02/02/2002")),
            listOf(Project("Name", "Subtitle", "Link", "Description", 1))
        )
    }
}