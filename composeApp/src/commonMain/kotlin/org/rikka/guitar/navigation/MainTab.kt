package org.rikka.guitar.navigation

/**
 * 主导航四个 Tab。
 */
enum class MainTab(
    val title: String,
    val iconLabel: String,
) {
    CheckIn("打卡", "✓"),
    Tools("工具", "◆"),
    Learn("学习", "◇"),
    Profile("我的", "○"),
}
