package com.locotodevteam.tipcalculatorcompose.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Number,
    onAction: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
    ) {
    OutlinedTextField(
        value = valueState.value, onValueChange = onValueChange,
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
        leadingIcon = { Icon(imageVector = Icons.Rounded.AttachMoney, contentDescription = "Money icon")},
        label = { Text(text = labelId) },
        enabled = enabled,
        singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Done),
        keyboardActions = onAction)
}