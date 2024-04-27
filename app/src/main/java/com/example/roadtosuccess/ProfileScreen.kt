package com.example.roadtosuccess

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.roadtosuccess.ui.theme.colorPrimary
import com.example.roadtosuccess.ui.theme.white

@Composable
fun ProfileScreen(navController: NavController){

    Box(
        modifier = Modifier
            .background(colorPrimary)
            .fillMaxSize()
            .padding(
                top = 200.dp
            )
    ){
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
                ProfileSection()
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

            ){
                ProfileGrid(photos = listOf(
                    Photos(title = "Abhijeet", iconId = R.drawable.img1),
                    Photos(title = "Abhijeet2", iconId = R.drawable.img2),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img3),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img4),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img5),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img6),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img7),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img8),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img9),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img10),
                    Photos(title = "Abhijeet3", iconId = R.drawable.img11),
                    ))
            }
        }
    }
}

@Composable
@Preview
fun ProfilePreview(){
    ProfileScreen(NavController(LocalContext.current))
}


@Composable
fun ProfileSection(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(
            bottom = 60.dp
        )

    ) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .border(1.dp, Color.White, CircleShape)
                .clip(CircleShape),
            painter = painterResource(com.example.roadtosuccess.R.drawable.ic_profile),
            contentDescription = "Profile",
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = "Abhijeet Singh",
            color = white,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp
        )
        Text(
            text = "Android Developer",
            color = white,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp
        )

     }
   }

@Composable
fun ProfileGrid(photos: List<Photos>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(photos.size) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = photos[it].iconId),
                    contentDescription = "login_bg",
                    modifier = Modifier
                        .border(1.dp, Color.White, RoundedCornerShape(10))
                        .clip(RoundedCornerShape(10))
                        .wrapContentWidth(),
                )
            }
        }
    }
}

data class Photos(
    val title: String,
    @DrawableRes val iconId: Int,
)



