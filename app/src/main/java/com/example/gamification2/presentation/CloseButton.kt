package com.example.gamification2.presentation


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
 * TODO Пихнуть цвета в тему
 * **/

@Preview
@Composable
fun CloseButtonPreview() {
    CloseButton()
}

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {}
) {

    IconButton(
        modifier = modifier
            .size(24.dp),
        onClick = {
            onDismissRequest()
            /**
             * нет плавного закрытия BottomSheet,
             * сохранения данных при закрытии
             * ripple эффекта
             */
        },
        content = {
            Icon(
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(Color(0xFFCCCCCC)),
                imageVector = Icons.Filled.Close,
                contentDescription = stringResource(
                    id = R.string.close_btn_ds
                ),
                tint = Color.White
            )
        }

    )

}