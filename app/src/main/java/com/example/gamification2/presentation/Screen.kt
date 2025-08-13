package com.example.gamification2.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.abs
import kotlin.math.sin
//import coil.compose.SubcomposeAsyncImage
import com.example.gamification2.R

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CurvedListScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurvedListScreen() {
    // 1. Создание и запоминание данных.
    //
    // 'remember' используется, чтобы список создавался только один раз
    // при первом запуске композиции.
    val items = remember {
        (1..50).map { "Box $it" }
    }

    // 2. Управление состоянием списка.
    //
    // 'rememberLazyListState' позволяет отслеживать,
    // где находится список, какие элементы видны и их смещение.
    //
    // Это ключевой элемент для создания эффекта,
    // так как мы будем использовать эту информацию для расчётов.
    val listState = rememberLazyListState()

    Scaffold(
        content = { padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = padding),
//                    contentAlignment = Alignment.Center
            ) {

                // 3. Создание списка.
                //
                // 'LazyColumn' эффективно отображает большие списки,
                // создавая элементы только по мере необходимости.
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.End,
//                    contentPadding = PaddingValues(
//                        all = 100.dp
//                    )
                ) {

                    itemsIndexed(items) { index, item ->

                        // 4. Получение информации о видимом элементе.
                        //
                        // Мы получаем информацию только о тех элементах,
                        // которые в данный момент видны на экране.
                        val visibleItemsInfo = listState.layoutInfo.visibleItemsInfo
                        val currentItemInfo = visibleItemsInfo.find {
                            it.index == index
                        }

                        // 5. Защита от ошибок.
                        //
                        // Если элемент не виден
                        // (например, находится за пределами экрана),
                        // мы не применяем к нему трансформации.
                        //
                        // Это важно для производительности.
                        if (currentItemInfo == null) {
                            ListItem(
                                item = item,
                                translationX = 0f,
                                scale = 1f
                            )
                            return@itemsIndexed
                        }





                        // 6. Расчёт центральной точки.
                        //
                        // Вычисляем, где находится центр видимой области 'LazyColumn' в пикселях.
                        // 'listState.layoutInfo.viewportSize.height' возвращает общую высоту видимой части
                        // списка на экране.
                        //
                        // Разделив это значение пополам, мы получаем точное положение центра.
                        // Все последующие расчёты (смещение и масштабирование) будут использовать эту
                        // точку в качестве ориентира.
                        val viewportCenter = listState.layoutInfo
                            .viewportSize.height / 2f

                        // 7. Расчёт расстояния до центра.
                        //
                        // TODO Эта строка — сердце всего эффекта.
                        // TODO Мы вычисляем, насколько далеко
                        // TODO текущий элемент находится от центра экрана.
                        //
                        // 1. 'currentItemsInfo.offset': Это координата верхнего края элемента относительно
                        //    начала 'LazyColumn'.
                        // 2. '(currentItemsInfo.size / 2f)': Добавляем половину высоты элемента, чтобы
                        //    получить координату его центра.
                        // 3. '... - viewportCenter': Вычитаем координату центра видимой области.
                        //    Результат — это расстояние от центра элемента до центра экрана.
                        // 4. 'abs(...)': Используем 'abs()' (абсолютное значение), чтобы расстояние всегда
                        //    было положительным, независимо от того, находится элемент выше или ниже центра.
                        //
                        // Полученное значение 'distanceToCenter' является главным параметром для
                        // расчёта 'translationX' и 'scale'.
                        //
                        // Чем больше это значение, тем дальше
                        // элемент от центра и тем сильнее будет трансформация.
                        val distanceToCenter =
                            abs(currentItemInfo.offset + (currentItemInfo.size / 2f) - viewportCenter)

                        // 8. Константы для настройки эффекта.
                        //
                        // 'curveFactor' - регулирует "глубину" изгиба.
                        // Меньшее значение делает дугу более пологой.
                        val curveFactor = 0.6f

                        // 'scaleFactor' - регулирует, насколько сильно элементы по краям уменьшаются.
                        // Значение 0.9 означает, что минимальный масштаб будет 90%.
                        val scaleFactor = 0.7f

                        // 9. Расчёт смещения по оси X (изгиб).
                        //
                        // Мы используем функцию sin(), чтобы создать плавную дугу.
                        // Чем ближе элемент к центру ('distanceToCenter' меньше),
                        // тем меньше смещение 'translationX',
                        // и наоборот.
                        //
                        // Вычитание '100.dp.toPx()' используется для коррекции,
                        // чтобы дуга начиналась не от самого края экрана, а изнутри.
                        val translationX = with(LocalDensity.current) {
                            -(viewportCenter - 70.dp.toPx()) * sin(
                                (distanceToCenter / viewportCenter) * curveFactor
                            )
                        }
                        // TODO Можно изменять значение dp и будет какой - то другой изгиб

                        // 10. Расчёт масштаба.
                        //
                        // Элементы, которые находятся далеко от центра ('distanceToCenter' большое),
                        // будут иметь меньший масштаб.
                        val scale = 1f - (distanceToCenter / viewportCenter) * (1f - scaleFactor)





                        // 11. Применение трансформаций.
                        //
                        // Передаём вычисленные значения в наш компонент 'ListItem'.
                        ListItem(
                            item = item,
                            translationX = translationX,
                            scale = scale
                        )

                    }

                }

            }

        }

    )

}

// Компонент одного элемента списка
@Composable
fun ListItem(

    // Текстовые данные,
    // которые будут отображены внутри элемента списка.
    item: String,

    // Смещение элемента по горизонтали (по оси X).
    // Это ключевой параметр для создания эффекта "изгиба" списка.
    translationX: Float,

    // Масштаб элемента — насколько он будет увеличен или уменьшен.
    // Он отвечает за эффект "сужения" элементов по краям.
    scale: Float
) {

    Card(

        modifier = Modifier
            // Рзамер карточки
            .size(128.dp)
            // Расст. между соседними карточками
            .padding(vertical = 6.dp)

            // 12. Применение трансформаций с помощью 'graphicsLayer'.
            //
            // 'graphicsLayer' — это модификатор, который позволяет эффективно применять
            // трансформации (смещение, масштабирование, вращение, прозрачность)
            // без перерисовки всего элемента.
            .graphicsLayer {

                // Смещение по горизонтали
                //
                // 'translationX' перемещает элемент по оси X.
                // Значение вычисляется в родительской функции
                // на основе расстояния элемента до центра экрана.
                //
                // Это смещение создает эффект изгиба,
                // "выталкивая" элементы, расположенные далеко от центра, вправо,
                // тем самым формируя дугу.
                this.translationX = translationX

                // Масштабирование по горизонтали
                //
                // 'scaleX' управляет горизонтальным масштабом элемента.
                // Значение масштаба (0.0f до 1.0f)
                // также зависит от расстояния до центра экрана.
                //
                // Элементы ближе к центру имеют 'scaleX = 1.0f'
                // (нормальный размер), а по мере удаления от центра это значение уменьшается.
                // Это добавляет эффект перспективы, делая удаленные элементы визуально меньше.
                this.scaleX = scale

                // Масштабирование по вертикали
                //
                // 'scaleY' управляет вертикальным масштабом элемента.
                // Мы используем то же значение 'scale',
                // что и для 'scaleX'.
                //
                // Это критически важно, чтобы сохранить пропорции элемента и избежать
                // его искажения (растягивания или сплющивания).
                // Благодаря этому, элемент уменьшается
                // равномерно, что выглядит более естественно.
                this.scaleY = scale

                /** TODO Я не понимаю, что делают scale - ы ? **/
            },

        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
            // Color(0xFF03DAC5)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )

    ) {

//        Box(
//            modifier = Modifier
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//
//            Text(
//                text = item,
//                color = Color.White,
//                fontSize = MaterialTheme.typography
//                    .headlineMedium.fontSize,
//                fontWeight = FontWeight.Bold
//            )
//
//        }

        ListCard()
    }

}


//        // SubcomposeAsyncImage - это компонент из библиотеки Coil для асинхронной загрузки изображений.
//        // Он автоматически загружает и отображает изображение из сети.
//        SubcomposeAsyncImage(
//            // Здесь должна быть ссылка на ваше изображение. Используем placeholder.
//            model = "https://picsum.photos/seed/$item/400/200",
//            contentDescription = "Image for $item",
//            // Заполнение всего доступного пространства Box.
//            modifier = Modifier.fillMaxSize(),
//            // Масштабирование изображения, чтобы оно заполняло всю область без искажений.
//            contentScale = ContentScale.Crop
//        )
