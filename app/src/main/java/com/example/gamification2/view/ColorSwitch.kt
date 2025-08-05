package com.example.gamification2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun ColorSwitcherPreview() {
    ColorSwitcher()
}

@Composable
fun ColorSwitcher() {

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    /**
     * TODO Чет думается мне, под собаку придётся писать custom view на Canvas
     * **/
    val dogColors = listOf(
        Color(0xFFA7491C),
        Color(0xFF57616C),
        Color(0xFF24303F),
    )

    val roverColors = listOf(
        Color.Transparent,
        Color(0xFFDF74AF),
        Color(0xFF74ABDF),
        Color(0xFFBFDF74),
        Color(0xFFF0D662),
        Color(0xFF8B74DF)
    )

    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        roverColors.forEachIndexed { index, color ->

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(color)
                    .border(
                        width = if (index == selectedIndex) 2.dp else 0.dp,
                        color = if (index == selectedIndex) Color.Blue else Color.Transparent,
                        shape = CircleShape
                    )
                    .clickable {
                        selectedIndex = index
                    }
            )

        }

    }

}