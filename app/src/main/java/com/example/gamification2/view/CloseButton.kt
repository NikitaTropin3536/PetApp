package com.example.gamification2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamification2.R

/**
 * todo Пихнуть цвета в тему
 * todo Разобраться с действием
 * **/

@Preview
@Composable
fun CloseButtonPreview() {
    CloseButton()
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier
) {

    IconButton(
        modifier = modifier
            .size(24.dp),
        onClick = { /** Обработка нажатия **/ },
        content = {

            Icon(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFCCCCCC)),
                imageVector = Icons.Filled.Close,
                contentDescription = stringResource(
                    id = R.string.close_btn
                ),
                tint = Color.White
            )
        }

    )

}