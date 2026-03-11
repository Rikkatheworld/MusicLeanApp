package org.rikka.guitar.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.prefs.Preferences

actual fun createUserProfileRepository(): UserProfileRepository {
    return JvmUserProfileRepository()
}

private class JvmUserProfileRepository : UserProfileRepository {
    
    private val prefs: Preferences = Preferences.userNodeForPackage(JvmUserProfileRepository::class.java)
    
    private val _profileFlow = MutableStateFlow(loadProfile())
    
    override fun getUserProfile(): Flow<UserProfile> = _profileFlow.asStateFlow()
    
    override suspend fun saveUserProfile(profile: UserProfile) {
        prefs.put(KEY_NICKNAME, profile.nickname)
        prefs.put(KEY_AVATAR_URI, profile.avatarUri ?: "")
        prefs.put(KEY_PHONE_NUMBER, profile.phoneNumber)
        prefs.put(KEY_UID, profile.uid)
        prefs.flush()
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
        val avatarUri = prefs.get(KEY_AVATAR_URI, "")
        return UserProfile(
            nickname = prefs.get(KEY_NICKNAME, UserProfile.DEFAULT_NICKNAME),
            avatarUri = avatarUri.ifEmpty { null },
            phoneNumber = prefs.get(KEY_PHONE_NUMBER, ""),
            uid = prefs.get(KEY_UID, "")
        )
    }
    
    companion object {
        private const val KEY_NICKNAME = "nickname"
        private const val KEY_AVATAR_URI = "avatar_uri"
        private const val KEY_PHONE_NUMBER = "phone_number"
        private const val KEY_UID = "uid"
    }
}
