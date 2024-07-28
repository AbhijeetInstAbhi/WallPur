package com.example.roadtosuccess.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import coil.compose.AsyncImage
import com.example.roadtosuccess.R
import com.example.roadtosuccess.data.model.Photos
import com.example.roadtosuccess.view.theme.colorPrimary
import com.example.roadtosuccess.view.theme.white
import com.example.roadtosuccess.viewmodel.MainViewModel

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
                ProfileGrid(viewModel = MainViewModel())
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
            painter = painterResource(R.drawable.ic_profile),
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
fun ProfileGrid(viewModel: MainViewModel){
    val photos by viewModel.imagelist

    LaunchedEffect(Unit) {
        viewModel.getPosts()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(photos.size) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = photos[it].base64,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        }
                        .wrapContentHeight()
                )
            }
        }
    }
}





