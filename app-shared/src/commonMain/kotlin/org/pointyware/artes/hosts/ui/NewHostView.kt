package org.pointyware.artes.hosts.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 *
 */
@Composable
fun NewHostView(
    // TODO: create state object and generalize to existing hosts
    modifier: Modifier = Modifier,
    onHostCreated: (String, String, String) -> Unit
) {
    var hostName by remember { mutableStateOf("") }
    var orgId by remember { mutableStateOf("") }
    var apiKey by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = hostName,
            onValueChange = { hostName = it },
            label = { Text("Host Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = orgId,
            onValueChange = { orgId = it },
            label = { Text("Organization Id") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = apiKey,
            onValueChange = { apiKey = it },
            label = { Text("API Key") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                onHostCreated(hostName, orgId, apiKey)
            }
        ) {
            Text("Create Host")
        }
    }
}
