package uk.co.jamiecruwys.cv.ui.tabs.summary

import org.junit.Before
import org.junit.Test
import uk.co.jamiecruwys.cv.model.Award
import uk.co.jamiecruwys.cv.model.Course
import uk.co.jamiecruwys.cv.model.Experience
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class SummaryPresenterTest {

    private lateinit var tester: SummaryPresenterTester

    @Before
    fun setUp() {
        tester = SummaryPresenterTester()
    }

    @Test
    fun `given null profile, when app resumes, then everything hidden`() {
        // Given
        tester.setProfile(null)

        // When
        tester.onResume()

        // Then
        tester.verifyHideName()
        tester.verifyHidePosition()
        tester.verifyHideContactInfoContainer()
        tester.verifyHidePhone()
        tester.verifyHideEmail()
        tester.verifyHideSummary()
        tester.verifyHideCommunity()
        tester.verifyHideEducation()
        tester.verifyNoMoreInteractions()
    }

    @Test
    fun `given profile with name, when app resumes, name shown`() {
        // Given
        val name = "John"
        tester.setProfile(Profile(name = name))

        // When
        tester.onResume()

        // Then
        tester.verifyShowName(name)
        tester.verifyNeverHideName()
    }

    @Test
    fun `given profile with no name, when app resumes, name hidden`() {
        // Given
        tester.setProfile(Profile(name = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHideName()
        tester.verifyNeverShowName()
    }

    @Test
    fun `given profile with position, when app resumes, position shown`() {
        // Given
        val position = "Technical Lead"
        tester.setProfile(Profile(position = position))

        // When
        tester.onResume()

        // Then
        tester.verifyShowPosition(position)
        tester.verifyNeverHidePosition()
    }

    @Test
    fun `given profile with no position, when app resumes, position hidden`() {
        // Given
        tester.setProfile(Profile(position = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHidePosition()
        tester.verifyNeverShowPosition()
    }

    @Test
    fun `given profile with phone, when app resumes, phone shown`() {
        // Given
        val phone = "07123456789"
        tester.setProfile(Profile(phone = phone))

        // When
        tester.onResume()

        // Then
        tester.verifyHideContactInfoContainer()
        tester.verifyShowContactInfoContainer()
        tester.verifyShowPhone(phone)
        tester.verifyNeverHidePhone()
    }

    @Test
    fun `given profile with no phone, when app resumes, phone hidden`() {
        // Given
        tester.setProfile(Profile(phone = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHideContactInfoContainer()
        tester.verifyHidePhone()
        tester.verifyNeverShowContactInfoContainer()
        tester.verifyNeverShowPhone()
    }

    @Test
    fun `given profile with email, when app resumes, email shown`() {
        // Given
        val email = "test@test.com"
        tester.setProfile(Profile(email = email))

        // When
        tester.onResume()

        // Then
        tester.verifyHideContactInfoContainer()
        tester.verifyShowContactInfoContainer()
        tester.verifyShowEmail(email)
        tester.verifyNeverHideEmail()
    }

    @Test
    fun `given profile with no email, when app resumes, email hidden`() {
        // Given
        tester.setProfile(Profile(email = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHideContactInfoContainer()
        tester.verifyHideEmail()
        tester.verifyNeverShowContactInfoContainer()
        tester.verifyNeverShowEmail()
    }

    @Test
    fun `given profile with summary, when app resumes, summary shown`() {
        // Given
        val summary = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac aliquam urna, eget aliquam nisl."
        tester.setProfile(Profile(summary = summary))

        // When
        tester.onResume()

        // Then
        tester.verifyShowSummary(summary)
        tester.verifyNeverHideSummary()
    }

    @Test
    fun `given profile with no summary, when app resumes, summary hidden`() {
        // Given
        tester.setProfile(Profile(summary = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHideSummary()
        tester.verifyNeverShowSummary()
    }

    @Test
    fun `given profile with community, when app resumes, community shown`() {
        // Given
        val community = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Orci varius natoque penatibus et magnis."
        tester.setProfile(Profile(community = community))

        // When
        tester.onResume()

        // Then
        tester.verifyShowCommunity(community)
        tester.verifyNeverHideCommunity()
    }

    @Test
    fun `given profile with no community, when app resumes, community hidden`() {
        // Given
        tester.setProfile(Profile(community = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHideCommunity()
        tester.verifyNeverShowCommunity()
    }

    @Test
    fun `given profile with education, when app resumes, education shown`() {
        // Given
        val education = listOf(Course("1st", "University X", "John Smith"))
        tester.setProfile(Profile(education = education))

        // When
        tester.onResume()

        // Then
        tester.verifyShowEducation(education)
        tester.verifyNeverHideEducation()
    }

    @Test
    fun `given profile with empty education list, when app resumes, education hidden`() {
        // Given
        val education = listOf<Course>()
        tester.setProfile(Profile(education = education))

        // When
        tester.onResume()

        // Then
        tester.verifyHideEducation()
        tester.verifyNeverShowEducation()
    }

    @Test
    fun `given profile with no education, when app resumes, education hidden`() {
        // Given
        tester.setProfile(Profile(education = null))

        // When
        tester.onResume()

        // Then
        tester.verifyHideEducation()
        tester.verifyNeverShowEducation()
    }

    @Test
    fun `given full profile, when app resumes, then all fields shown`() {
        // Given
        tester.setProfile(dummyProfile)

        // When
        tester.onResume()

        // Then
        tester.verifyShowName(name)
        tester.verifyShowPosition(position)
        tester.verifyHideContactInfoContainer()
        tester.verifyShowContactInfoContainer(2)
        tester.verifyShowPhone(phone)
        tester.verifyShowEmail(email)
        tester.verifyShowSummary(summary)
        tester.verifyShowCommunity(community)
        tester.verifyShowEducation(education)
        tester.verifyNoMoreInteractions()
    }

    companion object {
        private const val name = "Name"
        private const val position = "Position"
        private const val phone = "Phone"
        private const val email = "Email"
        private const val summary = "Summary"
        private const val community = "Community"
        private val education = listOf(Course("Grade", "Location", "Name"))
        private val awards = listOf(Award("Name"))
        private val experiences = listOf(Experience(1, "Name", "Position", "01/01/2001", "02/02/2002"))
        private val projects = listOf(Project("Name", "Subtitle", "Link", "Description", 1))

        private val dummyProfile: Profile = Profile(name,
            position,
            phone,
            email,
            summary,
            community,
            education,
            awards,
            experiences,
            projects
        )
    }
}