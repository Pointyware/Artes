/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.agents.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.pointyware.artes.ui.AgentListView
import org.pointyware.artes.ui.mapToViewState
import org.pointyware.artes.viewmodels.AgentListViewModel

/**
 */
@Composable
fun AgentListScreen(
    viewModel: AgentListViewModel,
    onShowAgent: (Long)->Unit,
    onNewAgent: ()->Unit,
) {
    Surface {
        val viewState by viewModel.state.collectAsState()
        LaunchedEffect(Unit) {
            viewModel.onInit()
        }
        AgentListView(
            state = viewState.mapToViewState(),
            modifier = Modifier.fillMaxSize(),
            onSelectAgent = {
                onShowAgent(it)
            },
            onCreateAgent = {
                onNewAgent()
            }
        )
    }
}
