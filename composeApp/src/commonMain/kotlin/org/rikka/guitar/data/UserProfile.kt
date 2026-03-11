package org.rikka.guitar.data

data class UserProfile(
    val nickname: String = DEFAULT_NICKNAME,
    val avatarUri: String? = null,
    val phoneNumber: String = "",
    val uid: String = ""
) {
    companion object {
        const val DEFAULT_NICKNAME = "用户"
    }
}
