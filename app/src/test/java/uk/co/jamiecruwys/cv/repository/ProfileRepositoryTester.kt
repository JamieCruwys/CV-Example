package uk.co.jamiecruwys.cv.repository

import org.junit.Assert
import uk.co.jamiecruwys.cv.model.Profile

class ProfileRepositoryTester {

    private val repository: ProfileRepository = ProfileRepository()

    fun getProfile() = repository.get()

    fun saveProfile(profile: Profile) {
        repository.save(profile)
    }

    fun verifyProfileInRepository(profile: Profile) {
        Assert.assertEquals(profile, getProfile())
    }

    fun verifyEmptyRepository() {
        Assert.assertEquals(null, getProfile())
    }
}