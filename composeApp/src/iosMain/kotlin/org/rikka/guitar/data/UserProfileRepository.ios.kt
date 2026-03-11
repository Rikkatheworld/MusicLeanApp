package org.rikka.guitar.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import platform.Foundation.NSUserDefaults

actual fun createUserProfileRepository(): UserProfileRepository {
    return IosUserProfileRepository()
}

private class IosUserProfileRepository : UserProfileRepository {
    
    private val defaults = NSUserDefaults.standardUserDefaults
    
    private val _profileFlow = MutableStateFlow(loadProfile())
    
    override fun getUserProfile(): Flow<UserProfile> = _profileFlow.asStateFlow()
    
    override suspend fun saveUserProfile(profile: UserProfile) {
        defaults.setObject(profile.nickname, KEY_NICKNAME)
        defaults.setObject(profile.avatarUri, KEY_AVATAR_URI)
        defaults.setObject(profile.phoneNumber, KEY_PHONE_NUMBER)
        defaults.setObject(profile.uid, KEY_UID)
        defaults.synchronize()
        _profileFlow.value = profile
    }
    
    override suspend fun updateNickname(nickname: String) {
        val current = _profileFlow.value
        saveUserProfile(current.copy(nickname = nickname))
    }
    
    override suspend fun updateAvatarUri(uri: String?) {
        val current = _profileFlow.value
        saveUserProfile(current.copy(avatarUri = uri))
    }
    
    private fun loadProfile(): UserProfile {
        return UserProfile(
            nickname = defaults.stringForKey(KEY_NICKNAME) ?: UserProfile.DEFAULT_NICKNAME,
            avatarUri = defaults.stringForKey(KEY_AVATAR_URI),
            phoneNumber = defaults.stringForKey(KEY_PHONE_NUMBER) ?: "",
            uid = defaults.stringForKey(KEY_UID) ?: ""
        )
    }
    
    companion object {
        private const val KEY_NICKNAME = "user_profile_nickname"
        private const val KEY_AVATAR_URI = "user_profile_avatar_uri"
        private const val KEY_PHONE_NUMBER = "user_profile_phone_number"
        private const val KEY_UID = "user_profile_uid"
    }
}
