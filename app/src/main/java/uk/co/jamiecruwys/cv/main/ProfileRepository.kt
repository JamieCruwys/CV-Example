package uk.co.jamiecruwys.cv.main

import uk.co.jamiecruwys.cv.api.Profile

class ProfileRepository {
    private var profile: Profile? = null

    fun save(profile: Profile) {
        this.profile = profile
    }

    fun get(): Profile? = profile
}