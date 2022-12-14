package com.example.passive_cooling.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainMenu(
    //onLocationSharingChanged: (Boolean) -> Unit,
    //onUpdatePasswordClicked: () -> Unit,
    //onHelpButtonClicked: () -> Unit
) {
    val directionOptions = listOf("North", "East", "South", "West")
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        /** ------- PROMPT ----------------- */
        Text(text = "Welcome to Keep It Cool! \n" +
                "Please input your information")
        
        Spacer(modifier = Modifier.size(16.dp))

        /** ------- TEXT FIELDS ----------------- */
        var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
            mutableStateOf(TextFieldValue("example", TextRange(0, 7)))
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("City") },
            placeholder = { Text("Bothell") }
        )

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("State") },
            placeholder = { Text("WA") }
        )

        CreateSwitch("Allergies today")
        CreateSwitch("Noise outside today")

        /** ------- TOGGLE SWITCHES FOR DIRECTION ----------------- */
        var i = 0
        repeat(directionOptions.size) {
            CreateSwitch(directionOptions[i])
            i++
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSwitch(text: String) {
    var checked by remember { mutableStateOf(true) }

    Row(
        Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    )

    {
        Column {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 36.dp, end = 36.dp)
            )
        }

        Column(
        ) {
            Switch(
                modifier = Modifier.semantics { contentDescription = "Demo" },
                checked = checked,
                onCheckedChange = { checked = it })
        }
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