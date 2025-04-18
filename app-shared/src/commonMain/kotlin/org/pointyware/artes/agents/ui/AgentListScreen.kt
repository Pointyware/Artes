package org.pointyware.artes.agents.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
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
    viewModel: AgentListViewModel
) {
    val viewState by viewModel.state.collectAsState()
    AgentListView(
        state = viewState.mapToViewState(),
        modifier = Modifier.fillMaxSize(),
        onSelectAgent = {
//                    navController.navigateTo(Destination.AgentInfo)
        },
        onCreateAgent = {
//                    navController.navigateTo(Destination.AgentEditor)
        }
    )
}
