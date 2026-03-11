package org.rikka.guitar.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.core.content.edit

private var appContext: Context? = null

fun initUserProfileRepository(context: Context) {
    appContext = context.applicationContext
}

actual fun createUserProfileRepository(): UserProfileRepository {
    val context = appContext ?: throw IllegalStateException(
        "UserProfileRepository not initialized. Call initUserProfileRepository(context) first."
    )
    return AndroidUserProfileRepository(context)
}

private class AndroidUserProfileRepository(context: Context) : UserProfileRepository {
    
    private val prefs: SharedPreferences = context.getSharedPreferences(
        PREFS_NAME, Context.MODE_PRIVATE
    )
    
    private val _profileFlow = MutableStateFlow(loadProfile())
    
    override fun getUserProfile(): Flow<UserProfile> = _profileFlow.asStateFlow()
    
    override suspend fun saveUserProfile(profile: UserProfile) {
        prefs.edit {
            putString(KEY_NICKNAME, profile.nickname)
                .putString(KEY_AVATAR_URI, profile.avatarUri)
                .putString(KEY_PHONE_NUMBER, profile.phoneNumber)
                .putString(KEY_UID, profile.uid)
        }
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
            nickname = prefs.getString(KEY_NICKNAME, UserProfile.DEFAULT_NICKNAME) 
                ?: UserProfile.DEFAULT_NICKNAME,
            avatarUri = prefs.getString(KEY_AVATAR_URI, null),
            phoneNumber = prefs.getString(KEY_PHONE_NUMBER, "") ?: "",
            uid = prefs.getString(KEY_UID, "") ?: ""
        )
    }
    
    companion object {
        private const val PREFS_NAME = "user_profile_prefs"
        private const val KEY_NICKNAME = "nickname"
        private const val KEY_AVATAR_URI = "avatar_uri"
        private const val KEY_PHONE_NUMBER = "phone_number"
        private const val KEY_UID = "uid"
    }
}
