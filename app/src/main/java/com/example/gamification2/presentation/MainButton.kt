package com.example.gamification2.presentation

import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamification2.R

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun SaveButtonPreview() {
    SaveButton()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    canClick: Boolean = false
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(
                horizontal = 16.dp,
            ),

        onClick = {
            // Обработка нажатия
        },
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            /** TODO Цвет кнопки меняется **/
            containerColor = if (canClick) Color(0xFF196DFF)
            else Color(0xFFF6F6F6)
        )
    ) {

        /** TODO Меняется наличие иконки - допилить **/
        if (canClick) {
            Icon(
                modifier = modifier,
                painter = painterResource(
                    id = R.drawable.navi_24_flip
                ),
                contentDescription = "something",
                /** TODO Меняется цвет иконки - допилить **/
                tint = if (canClick) Color.White
                else Color(0xFFCCCCCC)
            )
        }

        Text(
            modifier = modifier
                .padding(
                    horizontal = 6.dp
                ),
            /** TODO Меняется текст - допилить **/
            text = stringResource(
                id = R.string.go_walk
            ),
            /** TODO Меняется цвет текста - допилить **/
            color = if (canClick) Color.White
            else Color(0xFFCCCCCC),
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            lineHeight = 20.sp
        )

    }

}
