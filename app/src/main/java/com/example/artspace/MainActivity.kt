package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceApp() {
    ArtButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ArtButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.cuadro_1
        2 -> R.drawable.cuadro_2
        3 -> R.drawable.cuadro_3
        4 -> R.drawable.cuadro_4
        5 -> R.drawable.cuadro_5
        else -> R.drawable.cuadro_6
    }
    val nameResource = when (result){
        1 -> R.string.picture1
        2 -> R.string.picture2
        3 -> R.string.picture3
        4 -> R.string.picture4
        5 -> R.string.picture5
        else -> R.string.picture6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "1"
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            stringResource(nameResource),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = {
                if (result - 1 < 1) {
                    result = 6
                } else
                    result -= 1
            }) {
                Text(stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.width(25.dp))
            Button(onClick = {
                if (result + 1 > 6) {
                    result = 1
                } else
                    result += 1
            }) {
                Text(stringResource(R.string.next))
            }
        }
    }
}