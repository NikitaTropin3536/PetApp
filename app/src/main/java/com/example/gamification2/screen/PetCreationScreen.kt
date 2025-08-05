package com.example.gamification2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamification2.R
import com.example.gamification2.view.CloseButton
import com.example.gamification2.view.NameMenu
import com.example.gamification2.view.PetChoosingView
import com.example.gamification2.view.SaveButton

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFFL
)
@Composable
fun PetCreationScreenView() {
    PetCreationScreen()
}

@Composable
fun PetCreationScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = stringResource(
                    id = R.string.my_pet
                ),
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
            )

            CloseButton()

        }

        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(32.dp)
        )

        Column(
            modifier = modifier
                .padding(start = 16.dp)
        ) {

            Text(
                text = stringResource(
                    id = R.string.choose_a_pet
                ),
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

            }

        }
//
//        Image()
//

        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(8.dp)
        )

//        Column(
//            modifier = modifier
//                .fillMaxWidth()
//                .padding(horizontal = 12.dp)
//        ) {
//
//            Text(
//                text = stringResource(
//                    id = R.string.think_pet_name
//                ),
//                color = Color.Black,
//                fontWeight = FontWeight.ExtraBold,
//                fontSize = 18.sp,
//            )
//
//            NameMenu()
//
//            Text(
//                text = stringResource(
//                    id = R.string.popular_names
//                ),
//                color = Color(0xFF878787),
//                fontSize = 16.sp,
//            )
//
//        }
//
//        SaveButton()
    }

}
