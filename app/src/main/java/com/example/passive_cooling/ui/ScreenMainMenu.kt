package com.example.passive_cooling.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMainMenu(
    //onLocationSharingChanged: (Boolean) -> Unit,
    //onUpdatePasswordClicked: () -> Unit,
    //onHelpButtonClicked: () -> Unit
) {
    val directionOptions = listOf("North", "East", "South", "West")
    Column(
        Modifier
            .padding(32.dp)
            .fillMaxWidth() //FILL THE FULL WIDTH OF THE SCREEN
            .size(2000.dp) //THE HEIGHT OF THE SCREEN
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()), //MAKES THE INPUT SCROLLABLE
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(32.dp))

        /** ------- PROMPT ----------------- */
        Text(
            text = "Welcome to Keep It Cool!",
            fontSize = 24.sp
        )
        Text(
            "Please input some information" +
                    " to get a recommendation",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.size(32.dp))

        /** ------- TEXT FIELDS ----------------- */
        var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
            mutableStateOf(TextFieldValue("", TextRange(0, 7)))
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("City") },
            placeholder = { Text("Bothell") }
        )

        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("State") },
            placeholder = { Text("WA") }
        )

        Spacer(modifier = Modifier.size(8.dp))

        //TODO: ADD A TIME PICKER FOR EARLIEST TIME
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Earliest time") },
            placeholder = { Text("7:00 AM") }
        )

        //TODO: ADD A TIME PICKER FOR LATEST TIME
        Spacer(modifier = Modifier.size(8.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Latest time") },
            placeholder = { Text("1:00 AM") }
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = "How are things today?",
            fontSize = 24.sp
        )

        CreateSwitch("Allergies today")
        CreateSwitch("Noise outside today")

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = "What floor are you on?",
            fontSize = 24.sp
        )

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Floor") },
            placeholder = { Text("1") }
        )

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = "Which windows are you considering opening?",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.size(8.dp))

        /** ------- TOGGLE SWITCHES FOR DIRECTION ----------------- */
        var i = 0
        repeat(directionOptions.size) {
            CreateSwitch(directionOptions[i])
            i++
        }

        Button(onClick = {}) {
            Text(
                text = "Get a Recommendation",
                color = Color.White,
                fontSize = 24.sp
            )
        }

    }
}

/** TOGGLE SWITCHES */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSwitch(text: String) {
    var checked by remember { mutableStateOf(true) }

    Row(
        Modifier
            .selectableGroup()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    )

    {

        /** ALIGN THE TEXT TO THE LEFT */
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        )
        {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        /** ALIGN THE TOGGLE SWITCH TO THE RIGHT */
        Box(
            modifier = Modifier
                .width(50.dp),
            contentAlignment = Alignment.Center
        )
        {
            Row(modifier = Modifier.fillMaxWidth())
            {
                Switch(
                    modifier = Modifier
                        .width(36.dp)
                        .padding(end = 48.dp)
                        .semantics { contentDescription = "Demo" },
                    checked = checked,
                    onCheckedChange = { checked = it }
                )
            }
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