package com.example.passive_cooling.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenMainMenu(
    //onLocationSharingChanged: (Boolean) -> Unit,
    //onUpdatePasswordClicked: () -> Unit,
    //onHelpButtonClicked: () -> Unit
) {

    Column (horizontalAlignment = Alignment.CenterHorizontally) {

        var checked by remember { mutableStateOf(true) }
        Switch(
            modifier = Modifier.semantics { contentDescription = "Demo" },
            checked = checked,
            onCheckedChange = { checked = it })
    }
}


//+++++++++++++++++++++PREVIEW +++++++++++++++++
@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    ScreenMainMenu(
        //onStartTrackingButtonClicked = {},
        //onMapButtonClicked = {}
    )
}