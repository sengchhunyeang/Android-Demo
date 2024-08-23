package com.example.material_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.material_design.ui.theme.Material_DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material_DesignTheme {
                ConstraintLayoutDemo()
            }
        }
    }
}


@Composable
fun MyConstrainLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        var (text1, text2, box) = createRefs()
        Text(
            text = "Hello world ",
            modifier = Modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }

        )
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
            .constrainAs(box) {
                top.linkTo(text1.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "This is a constraint layout", modifier = Modifier.constrainAs(text2) {
                top.linkTo(box.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }

        )
    }
}

@Composable
fun AdvancedConstrainLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (text1, text2, box, guideline, barrier) = createRefs()
        val topGuideline = createGuidelineFromTop(0.3f)
        val textBarrier = createEndBarrier(text1, text2)
        Text(text = "first Text ", modifier = Modifier.constrainAs(text1) {
            top.linkTo(topGuideline)
            start.linkTo(parent.start, margin = 16.dp)
        })
        Text(text = "Second text ", modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(box) {
                top.linkTo(text1.bottom, margin = 16.dp)
                start.linkTo(textBarrier, margin = 16.dp)
                width = Dimension.percent(0.4f)
            })
        val startGuideline = createGuidelineFromStart(0.5f)
        Text(text = "Aligned with the 50% guideline", modifier = Modifier.constrainAs(guideline) {
            top.linkTo(box.bottom, margin = 16.dp)
            start.linkTo(startGuideline)
        })
    }
}

//@Composable
//fun ConstraintLayoutDemo() {
//    ConstraintLayout(modifier = Modifier.size(200.dp)) {
//        val (redBox, blueBox, yellowBox, text) = createRefs()
//
//        Box(modifier = Modifier
//            .size(50.dp)
//            .background(Color.Red)
//            .constrainAs(redBox) {})
//
//        Box(modifier = Modifier
//            .size(50.dp)
//            .background(Color.Blue)
//            .constrainAs(blueBox) {
//                top.linkTo(redBox.bottom)
//                start.linkTo(redBox.end)
//            })
//
//        Box(modifier = Modifier
//            .size(50.dp)
//            .background(Color.Yellow)
//            .constrainAs(yellowBox) {
//                bottom.linkTo(blueBox.bottom)
//                start.linkTo(blueBox.end, 20.dp)
//            })
//
//        Text("Hello World", modifier = Modifier.constrainAs(text) {
//            top.linkTo(parent.top)
//            start.linkTo(yellowBox.start)
//        })
//
//    }
//}


//@Composable
//fun ConstraintLayoutDemo() {
//    ConstraintLayout(modifier = Modifier.size(200.dp)) {
//        val (redBox, blueBox, yellowBox, text, anotherYellowBox) = createRefs()
//
//        Box(
//            modifier = Modifier
//                .size(50.dp)
//                .background(Color.Red)
//                .constrainAs(redBox) {}
//        )
//
//        Box(
//            modifier = Modifier
//                .size(50.dp)
//                .background(Color.Blue)
//                .constrainAs(blueBox) {
//                    top.linkTo(redBox.bottom)
//                    start.linkTo(redBox.end)
//                }
//        )
//
//        Box(
//            modifier = Modifier
//                .size(50.dp)
//                .background(Color.Yellow)
//                .constrainAs(yellowBox) {
//                    bottom.linkTo(blueBox.bottom)
//                    start.linkTo(blueBox.end, 20.dp)
//                }
//        )
//
//        Box(
//            modifier = Modifier
//                .size(50.dp)
//                .background(Color.Yellow)
//                .constrainAs(anotherYellowBox) { // New unique reference
//                    bottom.linkTo(blueBox.bottom)
//                    start.linkTo(blueBox.end, 20.dp)
//                }
//        )
//
//        Text(
//            text = "Hello World",
//            modifier = Modifier.constrainAs(text) {
//                top.linkTo(parent.top)
//                start.linkTo(yellowBox.start)
//            }
//        )
//    }
//}


@Composable
fun ConstraintLayoutDemo() {
    ConstraintLayout(modifier = Modifier.size(200.dp)) {
        val (redBox, blueBox, yellowBox, text) = createRefs()
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(redBox) {})
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(redBox.end)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                bottom.linkTo(blueBox.bottom)
                start.linkTo(blueBox.end, 20.dp)
            })
        Text(text = "Hello World ", Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.start)
        })
    }
}

@Composable
fun ConstraintLayout(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button, text) = createRefs()
    }
}

