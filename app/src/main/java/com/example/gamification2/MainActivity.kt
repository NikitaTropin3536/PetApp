package com.example.gamification2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.gamification2.network.WeatherRepository
import com.example.gamification2.presentation.CurvedListScreen
import com.example.gamification2.ui.theme.Gamification2Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val weatherRepository = WeatherRepository()

            var text by remember { mutableStateOf("Loading") }

            LaunchedEffect(true) {  // при старет приложения выполняется запрос
                try {
                    val weather = weatherRepository.fetchWeather(
                        52.37125,
                        4.89388
                    )
                } catch (e: Exception) {
                    e.localizedMessage ?: "error"
                }
            }
            Text(text = text, Modifier.padding(30.dp), fontSize = 16.sp)

//            Gamification2Theme {
////                CurvedListScreen()
//
//                Log.i("Begin", "Begin")
//                var str: String? = "Something"
//                lifecycleScope.launch {
//                    try {
//                        val weather = weatherRepository.fetchWeather(
//                            52.37125,
//                            4.89388
//                        )
//
//                        str = weather!!.s
//
//                        Log.i("STR_WEATHER", str)
//                    } catch (e: Exception) {
//                        // Handle exception
//                    }
//
//                }
//
//            }

        }
    }
}
