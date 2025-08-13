package com.example.gamification2.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamification2.R

@Preview
@Composable
fun ListCardPreview() {
    ListCard()
}

@Composable
fun ListCard(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .size(128.dp)
            .clip(
                shape = RoundedCornerShape(12.dp)
            )
            .background(color = Color.Transparent)
    ) {

        Image(
            modifier = modifier
                .fillMaxSize(),
            painter = painterResource(
                id = R.drawable.group_43
            ),
            contentDescription = "somehtuin"

        )

        Text(
            modifier = modifier
                .align(Alignment.Center)
                .padding(top = 32.dp),
            text = "4",
            color = Color.Blue,
            fontWeight = FontWeight.ExtraBold, // FontWeight(500)
            fontSize = 32.sp,
            lineHeight = 18.sp,
        )

    }

}