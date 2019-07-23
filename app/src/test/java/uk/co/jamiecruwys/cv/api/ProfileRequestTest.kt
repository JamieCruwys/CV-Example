package uk.co.jamiecruwys.cv.api

import org.junit.Before
import org.junit.Test
import retrofit2.Response
import uk.co.jamiecruwys.cv.model.Award
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class ProfileRequestTest {

    private lateinit var tester: ProfileRequestTester

    @Before
    fun setUp() {
        tester = ProfileRequestTester()
    }

    @Test
    fun `given valid profile, when handling response from api, then show content`() {
        // Given
        val response: Response<Profile>? = tester.getSuccessfulResponse(dummyProfile)

        // When
        tester.handleResponse(response)

        // Then
        tester.verifySuccess(dummyProfile)
    }

    @Test
    fun `given null response, when handling response from api, then show error`() {
        // Given
        val response: Response<Profile>? = null

        // When
        tester.handleResponse(response)

        // Then
        tester.verifyFailure()
    }

    @Test
    fun `given null profile, when handling response from api, then show error`() {
        // Given
        val response: Response<Profile>? = tester.getSuccessfulResponse(null)

        // When
        tester.handleResponse(response)

        // Then
        tester.verifyFailure()
    }

    @Test
    fun `given server error, when handling response from api, then show error`() {
        // Given
        val response: Response<Profile>? = tester.getErrorResponse()

        // When
        tester.handleResponse(response)

        // Then
        tester.verifyFailure()
    }

    companion object {
        private val dummyProfile: Profile = Profile(
            "Name",
            "Position",
            "Phone",
            "Email",
            "Summary",
            "Community",
            listOf(Course("Name", "Grade", "Location")),
            listOf(Award("Name")),
            listOf(Experience(1, "Name", "Position", "01/01/2001", "02/02/2002")),
            listOf(Project("Name", "Subtitle", "Link", "Description", 1))
        )
    }
}