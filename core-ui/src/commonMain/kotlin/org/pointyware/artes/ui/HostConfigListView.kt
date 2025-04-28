/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.pointyware.artes.viewmodels.HostConfigListUiState
import org.pointyware.artes.viewmodels.HostConfigUiState

/**
 *
 */
@Composable
fun HostConfigListItem(
    state: HostConfigUiState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Text(
            text = state.title,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = state.host.localizedName(),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

/**
 *
 */
@Composable
fun HostConfigListView(
    state: HostConfigListUiState,
    modifier: Modifier = Modifier,
    onRegisterService: ()->Unit
) {
    Box(
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.hostConfigs) {
                HostConfigListItem(it)
            }
        }

        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = onRegisterService
        ) {
            Text(
                text = "Register Service"
            )
        }
    }
}
