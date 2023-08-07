package com.locotodevteam.tipcalculatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locotodevteam.tipcalculatorcompose.composables.InputField
import com.locotodevteam.tipcalculatorcompose.ui.theme.TipCalculatorComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorComposeTheme {
                MainContent()
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainContent() {
    val totalBillState = remember { mutableStateOf("") }
    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            InputField(
                valueState = totalBillState,
                labelId = "Enter your bill",
                enabled = true,
                isSingleLine = true,
                onValueChange = { totalBillState.value = it },
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    //TODO: - Calculate the tip

                    keyboardController?.hide()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    MainContent()
}