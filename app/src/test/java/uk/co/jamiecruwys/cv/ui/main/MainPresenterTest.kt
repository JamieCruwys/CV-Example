package uk.co.jamiecruwys.cv.ui.main

import org.junit.Before
import org.junit.Test
import uk.co.jamiecruwys.cv.model.Award
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class MainPresenterTest {

    private lateinit var tester: MainPresenterTester

    @Before
    fun setup() {
        tester = MainPresenterTester()
    }

    @Test
    fun `given app resumed, when request successful, then save profile and show content`() {
        // Given
        tester.setSuccessResponse(dummyProfile)

        // When
        tester.onResume()

        // Then
        tester.verifyHideContent()
        tester.verifyShowLoading()
        tester.verifyHideLoading()
        tester.verifySaveToRepository(dummyProfile)
        tester.verifyShowContent()
    }

    @Test
    fun `given app resumed, when request error, then show error and do not save or show content`() {
        // Given
        tester.setErrorResponse()

        // When
        tester.onResume()

        // Then
        tester.verifyHideContent()
        tester.verifyShowLoading()
        tester.verifyHideLoading()
        tester.verifyShowError()

        tester.verifyNeverSaveToRepository()
        tester.verifyNeverShowContent()
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