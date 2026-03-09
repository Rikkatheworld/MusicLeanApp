package org.rikka.guitar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.LocalContentColor
import androidx.compose.ui.unit.dp
import org.rikka.guitar.navigation.MainTab
import org.rikka.guitar.screens.checkin.CheckInScreen
import org.rikka.guitar.screens.learn.LearnScreen
import org.rikka.guitar.screens.profile.ProfileScreen
import org.rikka.guitar.screens.tools.ToolsScreen

@Composable
fun App() {
    MaterialTheme {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val tabs = remember { MainTab.entries }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    tabs.forEachIndexed { index, tab ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            icon = {
                                TabIcon(label = tab.iconLabel)
                            },
                            label = { Text(tab.title) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            ),
                        )
                    }
                }
            },
        ) { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues),
            ) {
                when (tabs[selectedIndex]) {
                    MainTab.CheckIn -> CheckInScreen()
                    MainTab.Tools -> ToolsScreen()
                    MainTab.Learn -> LearnScreen()
                    MainTab.Profile -> ProfileScreen()
                }
            }
        }
    }
}

@Composable
private fun TabIcon(label: String) {
    Box(
        modifier = Modifier.size(24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = LocalContentColor.current,
        )
    }
}
