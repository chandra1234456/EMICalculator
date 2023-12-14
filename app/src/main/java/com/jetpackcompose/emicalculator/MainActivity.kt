package com.jetpackcompose.emicalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.emicalculator.ui.theme.EmiCalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmiCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize() ,
                        color = Color.White
                       ) {
                    TextValue()
                    TextInputLayoutAndEditText()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TextInputLayoutAndEditText() {
        var text by remember { mutableStateOf(TextFieldValue("")) }

        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.dp)
              ) {

            // OutlinedTextFieldBackground(Color.LightGray){
            OutlinedTextField(
                    value = text ,
                    onValueChange = { newValue ->
                        text = newValue
                        Log.d("onValueChange" , "TextInputLayoutAndEditText: $newValue")
                    } ,
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding() ,
                    label = { Text("Please Enter Emi Amount") } ,
                    placeholder = { Text("") } ,
                    singleLine = true ,
                    maxLines = 1

                             )
            // }
        }
    }

    @Composable
    fun GreetingPreview() {
        EmiCalculatorTheme {
            // Greeting("Android")
            TextInputLayoutAndEditText()

        }
    }
    @Composable
    fun TextValue() {
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
              ) {
            Text(
                    text = "EMI CALCULATOR" ,
                    style = MaterialTheme.typography.bodyLarge ,
                    modifier = Modifier.padding(8.dp) ,
                    fontSize = 20.sp ,
                    textAlign = TextAlign.Start ,
                    fontFamily = FontFamily.SansSerif ,
                    fontStyle = FontStyle(10)
                )
        }
    }
    @Composable
    fun OutlinedTextFieldBackground(
        color : Color ,
        content : @Composable () -> Unit
                                   ) {
        // This box just wraps the background and the OutlinedTextField
        Box {
            // This box works as background
            Box(
                    modifier = Modifier
                            .matchParentSize()
                            .padding(top = 8.dp) // adding some space to the label
                            .background(
                                    color ,
                                    // rounded corner to match with the OutlinedTextField
                                    shape = RoundedCornerShape(4.dp)
                                       )
               )
            // OutlineTextField will be the content...
            content()
        }
    }
}