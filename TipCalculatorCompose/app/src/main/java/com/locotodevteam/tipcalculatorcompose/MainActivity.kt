package com.locotodevteam.tipcalculatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.locotodevteam.tipcalculatorcompose.composables.BillForm
import com.locotodevteam.tipcalculatorcompose.composables.TopHeader
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

@Composable
fun MainContent() {
    val totalBillState = remember { mutableStateOf("") }
    val splitByState = remember { mutableStateOf(1) }
    val sliderPositionState = remember { mutableStateOf(0.1f) }
    val totalPerPerson = remember(totalBillState.value, splitByState.value, sliderPositionState.value) {
        if(totalBillState.value.isNotEmpty()) {
            mutableStateOf(totalBillState.value.toFloat() / splitByState.value * (1 + sliderPositionState.value))
        } else mutableStateOf(0f)
    }
    Column {
        TopHeader(totalPerPerson)
        BillForm(
            totalBillState = totalBillState,
            splitByState = splitByState,
            sliderPositionState = sliderPositionState,
            onValueChange = ::printBillAmount
        )
    }
}

fun printBillAmount(value: String) {
    println("chris, bill is: $value")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainContentPreview() {
    MainContent()
}