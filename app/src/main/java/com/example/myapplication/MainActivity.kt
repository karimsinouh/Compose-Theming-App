package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Themes
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState= rememberBottomSheetScaffoldState()
            val color = remember{mutableStateOf<Themes>(Themes.Blue)}
            val darkTheme= remember{ mutableStateOf(false) }
            val scope= rememberCoroutineScope()
            val expanded = remember{ mutableStateOf(false) }

            window.statusBarColor=if(darkTheme.value)
                android.graphics.Color.parseColor("#121212")
            else
                color.value.light.primaryVariant.toArgb()



                if (expanded.value)
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                else
                    scope.launch {
                        scaffoldState.bottomSheetState.collapse()
                    }

            MyApplicationTheme(
                darkTheme.value,
                color.value
            ) {
                BottomSheetScaffold(
                    topBar = {TopBar()},
                    sheetContent = {
                        MyBottomSheet(
                            color =color.value.getColor(),
                            expanded = expanded.value
                        ){
                            expanded.value= !expanded.value
                        }},
                    sheetPeekHeight = 60.dp,
                    sheetShape = RoundedCornerShape(8.dp,8.dp,0.dp,0.dp)
                ) {

                    Content(
                        darkTheme.value,
                        onColorChanged = { color.value=it },
                        onDarkThemeChanged = {darkTheme.value=it}
                    )
                }
            }

        }
    }

    @Composable
    fun TopBar(){
        TopAppBar {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Menu,"menu")
            }
            Text("Theming",
                Modifier
                    .fillMaxWidth()
                    .weight(0.9f),
                fontFamily = FontFamily.Monospace)

            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Search,"search")
            }

        }
    }

    @Composable
    fun Content(
        isDarkTheme:Boolean,
        onColorChanged:(Themes)->Unit,
        onDarkThemeChanged:(Boolean)->Unit
    ){
        
        val colors= listOf(Themes.Yellow,Themes.Purple,Themes.Blue,Themes.Green)
        
        Column(
            Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = "Dark Theme",
                fontFamily = FontFamily.Monospace,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text)
            Row(horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isDarkTheme,onCheckedChange ={onDarkThemeChanged(it)})
                Spacer(modifier = Modifier.width(4.dp))
                Text("Enable dark mode")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Theme Color",
                fontFamily = FontFamily.Monospace,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text("A dark theme displays dark surfaces across the majority of a UI. It's designed to be a supplemental mode to a default (or light) theme.")
            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                colors.forEach {
                    ColorItem(color = it.getColor()){
                        onColorChanged(it)
                    }
                }
                
            }
            
        }
    }
    
    @Composable
    fun ColorItem(color:Color,onClick:()->Unit){
        Box(
            Modifier
                .size(45.dp)
                .clip(CircleShape)
                .background(color)
                .clickable { onClick() },
        ){}
    }

    private val text="Dark themes reduce the luminance emitted by device screens, while still meeting minimum color contrast ratios. They help improve visual ergonomics by reducing eye strain, adjusting brightness to current lighting conditions, and facilitating screen use in dark environments – all while conserving battery power. Devices with OLED screens benefit from the ability to turn off black pixels at any time of day."

}