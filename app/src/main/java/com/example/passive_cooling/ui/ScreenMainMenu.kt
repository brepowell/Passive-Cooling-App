package com.example.passive_cooling.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenMainMenu(
    //onLocationSharingChanged: (Boolean) -> Unit,
    //onUpdatePasswordClicked: () -> Unit,
    //onHelpButtonClicked: () -> Unit
) {

    Column (horizontalAlignment = Alignment.CenterHorizontally) {

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