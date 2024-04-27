package com.example.roadtosuccess

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.roadtosuccess.Navigation.Screen
import com.example.roadtosuccess.ui.theme.AquaBlue
import com.example.roadtosuccess.ui.theme.BlueViolet1
import com.example.roadtosuccess.ui.theme.OrangeYellow2
import com.example.roadtosuccess.ui.theme.OrangeYellow3
import com.example.roadtosuccess.ui.theme.PurpleGrey40
import com.example.roadtosuccess.ui.theme.TextWhite
import com.example.roadtosuccess.ui.theme.colorPrimary
import com.example.roadtosuccess.ui.theme.gray
import com.example.roadtosuccess.ui.theme.skyblue1
import com.example.roadtosuccess.ui.theme.skyblue2
import com.example.roadtosuccess.ui.theme.skyblue3
import com.example.roadtosuccess.ui.theme.white

@ExperimentalFoundationApi
@Composable
fun HomeDesign(navController: NavController) {



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 50.dp
            )
    ) {
        ConstraintLayout {
            val (logoimageref, loginformref) = createRefs()
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(280.dp)
                    .constrainAs(logoimageref) {
                        top.linkTo(loginformref.top)
                        bottom.linkTo(loginformref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                Header2()
                GreetingSection(navController)
            }

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp)
                    .constrainAs(loginformref) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column {
                    suggestionSection()
                    CourseSection(
                        courses = listOf(
                            Course(
                                title = "Nature",
                                com.example.roadtosuccess.R.drawable.ic_headphone,
                                gray,
                                gray,
                                gray
                            ),
                            Course(
                                title = "Graffiti",
                                com.example.roadtosuccess.R.drawable.ic_videocam,
                                gray,
                                gray,
                                gray
                            ),
                            Course(
                                title = "Street",
                                com.example.roadtosuccess.R.drawable.ic_play,
                                gray,
                                gray,
                                gray
                            ),
                            Course(
                                title = "Micro",
                                com.example.roadtosuccess.R.drawable.ic_headphone,
                                gray,
                                gray,
                                gray
                            ),
                            Course(
                                title = "Portrait",
                                com.example.roadtosuccess.R.drawable.ic_play,
                                gray,
                                gray,
                                gray
                            ),
                            Course(
                                title = "PSD Section",
                                com.example.roadtosuccess.R.drawable.ic_videocam,
                                gray,
                                gray,
                                gray
                            ),
                        )
                    )
                }
            }
        }
        BottomMenu(navController,
            items = listOf(
                BottomMenuContent("Home", com.example.roadtosuccess.R.drawable.ic_home),
                BottomMenuContent("Post", com.example.roadtosuccess.R.drawable.baseline_add_circle_24),
                BottomMenuContent("Feed", com.example.roadtosuccess.R.drawable.baseline_add_link_24),
                BottomMenuContent("Profile", com.example.roadtosuccess.R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

    @Composable
    fun ChipSection(
        chips: List<String>
    ) {
        var selectedChipIndex by remember {
            mutableStateOf(0)
        }
        val contextt = LocalContext.current

        LazyRow {
            items(chips.size) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable {
                            selectedChipIndex = it
                            Toast
                                .makeText(contextt, chips[selectedChipIndex], Toast.LENGTH_SHORT)
                                .show()
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedChipIndex == it) OrangeYellow3
                            else BlueViolet1
                        )
                        .padding(15.dp)
                ) {
                    Text(text = chips[it], color = TextWhite)
                }
            }
        }
    }

@Composable
fun GreetingSection(navController: NavController) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .border(1.dp, Color.White, CircleShape)
                .clip(CircleShape)
                .clickable {
                    navController.navigate(Screen.ProfileScreen.route)
                },
            painter = painterResource(com.example.roadtosuccess.R.drawable.ic_profile),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hi, Abhijeet",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Welcome!",
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )

        }
        Icon(painter = painterResource(id = com.example.roadtosuccess.R.drawable.ic_search), contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun suggestionSection(
    color: Color = colorPrimary
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Make a Request!",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
            Text(
                text = "Add your requirement!",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(gray)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = com.example.roadtosuccess.R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun CourseSection(courses: List<Course>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(courses.size) {
                CourseItem(course = courses[it])
            }
        }
    }
}

    @Composable
    fun CourseItem(
        course: Course
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(course.darkColor)
        ) {
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            // Medium colored path
            val mediumColoredPoint1 = Offset(0f, height * 0.3f)
            val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
            val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
            val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
            val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

            val mediumColoredPath = Path().apply {
                moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
                standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
                standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
                standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
                standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }

            // Light colored path
            val lightPoint1 = Offset(0f, height * 0.35f)
            val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
            val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
            val lightPoint4 = Offset(width * 0.65f, height.toFloat())
            val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

            val lightColoredPath = Path().apply {
                moveTo(lightPoint1.x, lightPoint1.y)
                standardQuadFromTo(lightPoint1, lightPoint2)
                standardQuadFromTo(lightPoint2, lightPoint3)
                standardQuadFromTo(lightPoint3, lightPoint4)
                standardQuadFromTo(lightPoint4, lightPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }
            val contextt = LocalContext.current
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                drawPath(
                    path = mediumColoredPath,
                    color = course.mediumColor
                )
                drawPath(
                    path = lightColoredPath,
                    color = course.lightColor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Text(
                    text = course.title,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 26.sp,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                Icon(
                    painter = painterResource(id = course.iconId),
                    contentDescription = course.title,
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(contextt, course.title, Toast.LENGTH_SHORT)
                                .show()
                        }
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .background(colorPrimary)
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                )
            }
        }
    }

@Composable
fun BottomMenu(
    navController: NavController,
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = colorPrimary,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = gray,
    initialSelectedItemIndex: Int = 0,
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(5.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                navController,
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    navController: NavController,
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = OrangeYellow3,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    val contextt = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
            when(item.title) {
                "Home" -> print("Sun is a Star")
                "Post" -> print("Moon is a Satellite")
                "Feed" -> print("Earth is a planet")
                "Profile" -> navController.navigate(Screen.ProfileScreen.route)
                else -> print("I don't know anything about it")
            }
            Toast.makeText(contextt, item.title, Toast.LENGTH_SHORT).show()

        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun Header2() {
    Image(
        painter = painterResource(id = R.drawable.loginbg2),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .size(200.dp)
            .fillMaxHeight()
    )
    Column(
        modifier = Modifier.padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      /*  Image(
            painter = painterResource(id = R.drawable.samplelogo),
            modifier = Modifier
                .size(30.dp)
                .border(1.dp, Color.White, CircleShape)
                .clip(CircleShape)
                .wrapContentWidth(),
            contentDescription = "login_bg",

            )

        Text(
            text = "WallPur",
            color = white,
            fontSize =20.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp
        )*/
    }
}
