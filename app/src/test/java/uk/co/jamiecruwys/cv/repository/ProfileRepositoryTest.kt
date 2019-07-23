package uk.co.jamiecruwys.cv.repository

import org.junit.Before
import org.junit.Test
import uk.co.jamiecruwys.cv.model.Award
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class ProfileRepositoryTest {

    private lateinit var tester: ProfileRepositoryTester

    @Before
    fun setUp() {
        tester = ProfileRepositoryTester()
    }

    @Test
    fun `given initial load, when retrieving profile, then return null`() {
        // Given

        // When

        // Then
        tester.verifyEmptyRepository()
    }

    @Test
    fun `given initial load, when saving profile, then profile saved`() {
        // Given

        // When
        tester.saveProfile(dummyProfile)

        // Then
        tester.verifyProfileInRepository(dummyProfile)
    }

    @Test
    fun `given already has saved profile, when saving profile, then profile overridden`() {
        // Given
        tester.saveProfile(dummyProfile.copy(name = "John Doe", email = "test@test.com"))

        // When
        tester.saveProfile(dummyProfile)

        // Then
        tester.verifyProfileInRepository(dummyProfile)
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