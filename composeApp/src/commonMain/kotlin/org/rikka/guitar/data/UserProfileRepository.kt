package org.rikka.guitar.data

import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    fun getUserProfile(): Flow<UserProfile>
    suspend fun saveUserProfile(profile: UserProfile)
    suspend fun updateNickname(nickname: String)
    suspend fun updateAvatarUri(uri: String?)
}

expect fun createUserProfileRepository(): UserProfileRepository
