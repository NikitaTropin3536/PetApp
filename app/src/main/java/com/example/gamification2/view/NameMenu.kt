package com.example.gamification2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gamification2.R

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun NameMenuPreview() {
    NameMenu()
}

@Composable
fun NameMenu(
    modifier: Modifier = Modifier
) {

    var petName by remember {
        mutableStateOf("")
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
    ) {

        OutlinedTextField(
            modifier = modifier
                .weight(0.8f),
            value = petName,
            onValueChange = {
                petName = it
            },
            label = {
                Text(
                    text = stringResource(R.string.pet_name)
                )
            },
            shape = RoundedCornerShape(8.dp),
//                colors =
//                /** TODO Как - то там цвета поставить **/
            /** todo Прописать фигню с продолжением текста после строчки **/
        )

        Spacer(
            modifier = Modifier
                .weight(0.04F)
        )

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .size(56.dp)
                /** TODO Потом перенести цвет в темы **/
                .background(color = Color(0xFFF3F6FC))
                .align(Alignment.Bottom)
        ) {

            Icon(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.Center),
                painter = painterResource(
                    id = R.drawable.ic_dice
                ),
                contentDescription = stringResource(
                    id = R.string.name_generation
                ),
                tint = Color(0xFF196DFF)
            )

        }

    }

}

/** TODO Ещё раз проверить все отступы **/
