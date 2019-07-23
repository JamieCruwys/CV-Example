package uk.co.jamiecruwys.cv.api

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import uk.co.jamiecruwys.cv.model.Award
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class ProfileRequestTest {

    private val apiService: ApiService = mock()
    private val listener: APIResponseListener = mock()
    private lateinit var profileRequest: ProfileRequest

    @Before
    fun setUp() {
        profileRequest = ProfileRequest(apiService)
    }

    @Test
    fun `given valid profile, when handling response from api, then show content`() {
        // Given
        val response: Response<Profile>? = Response.success(dummyProfile)

        // When
        profileRequest.handleResponse(response, listener)

        // Then
        verify(listener).onSuccess(dummyProfile)
    }

    @Test
    fun `given null response, when handling response from api, then show error`() {
        // Given
        val response: Response<Profile>? = null

        // When
        profileRequest.handleResponse(response, listener)

        // Then
        verify(listener).onFailure()
    }

    @Test
    fun `given null profile, when handling response from api, then show error`() {
        // Given
        val response: Response<Profile>? = Response.success(null)

        // When
        profileRequest.handleResponse(response, listener)

        // Then
        verify(listener).onFailure()
    }

    @Test
    fun `given server error, when handling response from api, then show error`() {
        // Given
        val response: Response<Profile>? = Response.error(404, ResponseBody.create(MediaType.get("application/json"), ""))

        // When
        profileRequest.handleResponse(response, listener)

        // Then
        verify(listener).onFailure()
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