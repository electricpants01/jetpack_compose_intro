package com.locotodevteam.tipcalculatorcompose.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locotodevteam.tipcalculatorcompose.showPercentage

@Composable
fun Slider(
    modifier: Modifier = Modifier,
    sliderPositionState: MutableState<Float>
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = sliderPositionState.value.showPercentage())
        Spacer(modifier = Modifier.height(14.dp))
        Slider( modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            value = sliderPositionState.value, onValueChange = { newValue ->
            sliderPositionState.value = newValue
        }, steps = 5)
    }
}


@Preview
@Composable
fun SliderPreview() {
    Slider(sliderPositionState = remember {
        mutableStateOf(0.1f)
    })
}