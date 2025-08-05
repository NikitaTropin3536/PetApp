package com.example.gamification2.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamification2.R

/**
 * todo Пихнуть цвета в тему
 * todo Ещё раз проверить отступы
 * todo Разобраться с состояниями
 * **/

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun PetChoosingElementPreview() {
    PetChoosingElement()
}

@Composable
fun PetChoosingElement(
    modifier: Modifier = Modifier,
    @StringRes petResId: Int = R.string.pet_nobody,
    @DrawableRes avatarResId: Int = R.drawable.ic_default_pet,
) {

    Column(

        modifier = modifier
            .width(72.dp)
            .height(86.dp)
            .padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {

            IconButton(

                modifier = modifier
                    .size(56.dp)
                    .padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(20.dp)), // вот это под вопросом
                onClick = {
//                    isSelected = !isSelected
                },
                content = {

                    Icon(
                        painter = painterResource(
                            id = avatarResId
                        ),
                        contentDescription = stringResource(
                            id = R.string.pet_avatar_description
                        ),
//                        tint = if (isSelected) Color(0xFF196DFF) else Color(0xFFF6F6F6)
                    )

                }

            )

            Text(
                modifier = modifier
                    .padding(top = 8.dp),
                text = stringResource(
                    id = petResId
                ),
                color = Color.Black,
                fontWeight = FontWeight(400),
                fontSize = 12.sp,
                lineHeight = 14.sp
            )

        }

    )

}

