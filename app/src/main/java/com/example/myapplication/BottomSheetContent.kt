package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyBottomSheet(
    color:Color,
    expanded:Boolean,
    onExpand:()->Unit
)= Column{

    Row(
        modifier = Modifier
            .height(60.dp)
            .background(color)
            .padding(12.dp, 0.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Bottom Sheet",
            modifier=Modifier.weight(0.9f),
            color= Color.White
            )
        IconButton(onClick = onExpand) {
            if (!expanded){
                Icon(Icons.Outlined.KeyboardArrowUp, "",tint = Color.White)
            }else{
                Icon(Icons.Outlined.KeyboardArrowDown, "",tint = Color.White)
            }
        }
    }

    Column(Modifier.padding(12.dp)){

        Text(
            text = "Bottom Sheet",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )

        Text(
            text="Compose for Desktop provides a declarative and reactive approach to creating user interfaces with Kotlin. Combine composable functions to build your user interface, and enjoy full tooling support from your IDE and build system – no XML or templating language required.\n" +
                    "\n" +
                    "Compose for Desktop targets the JVM, and supports high-performance, hardware-accelerated UI rendering on all major desktop platforms (macOS, Windows, and Linux/x64) by leveraging the powerful native Skia graphics library.",
            fontFamily = FontFamily.Monospace
        )

    }

}