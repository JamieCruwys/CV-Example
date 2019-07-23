package uk.co.jamiecruwys.cv.ui.tabs.experience

import org.junit.Before
import org.junit.Test
import uk.co.jamiecruwys.cv.model.Profile
import uk.co.jamiecruwys.cv.model.Project

class ProjectPresenterTest {

    private lateinit var tester: ProjectPresenterTester

    @Before
    fun setUp() {
        tester = ProjectPresenterTester()
    }

    @Test
    fun `given null profile, when show projects called, then no projects shown`() {
        // Given
        tester.setProfile(null)

        // When
        tester.onResume()

        // Then
        tester.verifyShowProjects(listOf())
    }

    @Test
    fun `given profile with null projects, when show projects called, then no projects shown`() {
        // Given
        tester.setProfile(Profile())

        // When
        tester.onResume()

        // Then
        tester.verifyShowProjects(listOf())
    }

    @Test
    fun `given profile with empty list of projects, when show projects called, then no projects shown`() {
        // Given
        tester.setProfile(Profile(projects = listOf()))

        // When
        tester.onResume()

        // Then
        tester.verifyShowProjects(listOf())
    }

    @Test
    fun `given profile with one project, when show projects called, then one project shown`() {
        // Given
        tester.setProfile(Profile(projects = oneProject))

        // When
        tester.onResume()

        // Then
        tester.verifyShowProjects(oneProject)
    }

    @Test
    fun `given profile with many project, when show projects called, then all projects shown`() {
        // Given
        tester.setProfile(Profile(projects = manyProjects))

        // When
        tester.onResume()

        // Then
        tester.verifyShowProjects(manyProjects)
    }

    companion object {
        private val projectOne = Project("Project One", "First", "Link", "Description", 1)
        private val projectTwo = Project("Project Two", "Second", "Link", "Description", 2)
        private val oneProject = listOf(projectOne)
        private val manyProjects = listOf(projectOne, projectTwo, projectTwo, projectOne)
    }
}