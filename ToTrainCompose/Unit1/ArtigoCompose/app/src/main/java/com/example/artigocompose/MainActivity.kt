package com.example.artigocompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artigocompose.ui.theme.ArtigoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtigoComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    printAll()
                }
            }
        }
    }
}

//setText in argument with different variables
@Composable
fun setText(
    text: String,
    size: Int = 16,
    type: String = "sp",
    padding: Int,
    justify: Boolean = false,
    modifier: Modifier = Modifier
) {
    val textSize = when (type.lowercase()) {
        "dp" -> size.dp
        else -> size.sp // Default para sp
    }

    Text(
        text = text,
        fontSize = if (textSize is TextUnit) textSize else size.sp,
        //lineHeight = 20.sp,
        textAlign = if (justify) TextAlign.Justify else TextAlign.Start,
        modifier = modifier.padding(padding.dp),
        )
}

//@Composable
//private fun ArticleCard(
//    title: String,
//    shortDescription: String,
//    longDescription: String,
//    imagePainter: Painter,
//    modifier: Modifier = Modifier,
//) {
//    Column(modifier = modifier) {
//        Image(painter = imagePainter, contentDescription = null)
//        Text(
//            text = title,
//            modifier = Modifier.padding(16.dp),
//            fontSize = 24.sp
//        )
//        Text(
//            text = shortDescription,
//            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
//            textAlign = TextAlign.Justify
//        )
//        Text(
//            text = longDescription,
//            modifier = Modifier.padding(16.dp),
//            textAlign = TextAlign.Justify
//        )
//    }
//}

//print all the text using the setText function
@Composable
fun printAll(){
    Column (modifier = Modifier.padding(16.dp)) {
        setImage(painterResource(R.drawable.bg_compose_background))
        setText(stringResource(R.string.title), 24, "sp", 16, false)
        setText(stringResource(R.string.text1), type = "sp", padding = 16, justify = false)
        setText(stringResource(R.string.text2), padding = 16, justify = true)
    }
}

@Composable
fun setImage(image: Painter, modifier: Modifier = Modifier){
    Box(modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter) {
        Image(
            painter = image,
            contentDescription = null,
            //modifier = Modifier.fillMaxSize(),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtigoComposeTheme {
        printAll()
    }
}