package com.example.jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            children()
        }
    }
}

@Composable
fun MyScreenContent(
    names: List<String> = listOf("Android", "there"),
    counterState: CounterState = CounterState()
) {
    Column(modifier = LayoutHeight.Fill) {
        Column(modifier = LayoutWeight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(counterState)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = LayoutPadding(24.dp))
}

@Model
class CounterState(var count: Int = 0)

//@Model
//class FormState(var optionChecked: Boolean)
//
//@Composable
//fun Form(formState: FormState) {
//    Checkbox(
//        checked = formState.optionChecked,
//        modifier = LayoutPadding(24.dp),
//        onCheckedChange = { newState -> formState.optionChecked = newState })
//}

@Composable
fun Counter(state: CounterState) {
    Button(
        onClick = { state.count++ },
        backgroundColor = if (state.count > 5) Color.Green else Color.White
    ) {
        Text("I've been clicked ${state.count} times")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}

//@Preview
//@Composable
//fun DefaultPreview2() {
//    Counter(CounterState(1))
//}
