package com.example.gamification2.presentation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gamification2.R

// Это Box для погоды и подарка
@Composable
fun SpecialBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .clip(
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color(0xFFCED4E3))
            // цвет в фигме слишком светлый- я поменял

        /**
         * Клик не прописывал
         */
    ) {

//        Icon(
//            modifier = Modifier
//                .size(28.dp)
//                .align(Alignment.Center),
//            painter = painterResource(
//                id = R.drawable.navi_24_flip
//            ),
//            contentDescription = stringResource(
////                id = R.string.name_generation_ds
//                TODO()
//            ),
//            tint = Color(0xFF196DFF)
//        )

    }
}