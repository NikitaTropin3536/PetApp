package com.example.gamification2.view

import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamification2.R

/**
 * todo Пихнуть цвета в тему
 * todo Разобраться с состояниями
 * **/

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun SaveButtonPreview() {
    SaveButton()
}

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    canClick: Boolean = false
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (canClick) Color(0xFF196DFF)
            else Color(0xFFCCCCCC)
        ),
        onClick = { /** Обработка нажатия **/ }
    ) {

        Text(
            text = stringResource(
                id = R.string.save
            ),
            color = if (canClick) Color.White
            else Color(0xFFCCCCCC),
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 20.sp
        )

    }

}