package org.pointyware.artes.agents.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import org.pointyware.artes.agents.viewmodels.AgentUiState
import org.pointyware.artes.viewmodels.HostUiState
import org.pointyware.artes.viewmodels.ModelUiState

@Preview
@Composable
fun NewAgentViewPreview(
    @PreviewParameter(AgentUiStateProvider::class) state: AgentUiState
) {
    NewAgentView(
        modifier = Modifier.fillMaxSize(),
        state = state,
        onSelectHost = {},
        onSubmit = { _, _, _, _ -> }
    )
}
class AgentUiStateProvider: PreviewParameterProvider<AgentUiState> {
    override val values: Sequence<AgentUiState>
        get() = sequenceOf(
            AgentUiState(
                agentName = "",
                hosts = listOf(),
                selectedHost = null,
                hostModels = listOf(),
                selectedModel = null,
                instructions = ""
            ),
            AgentUiState(
                agentName = "NurseBot",
                hosts = listOf(
                    HostUiState(0L, "OpenAI"),
                    HostUiState(1L, "Anthropic")
                ),
                selectedHost = null,
                hostModels = listOf(),
                selectedModel = null,
                instructions = ""
            ),
            AgentUiState(
                agentName = "NurseBot",
                hosts = listOf(
                    HostUiState(0L, "OpenAI"),
                    HostUiState(1L, "Anthropic")
                ),
                selectedHost = 0,
                hostModels = listOf(
                    ModelUiState(0L, "GPT-3.5"),
                    ModelUiState(1L, "GPT4o"),
                ),
                selectedModel = null,
                instructions = ""
            ),
            AgentUiState(
                agentName = "NurseBot",
                hosts = listOf(
                    HostUiState(0L, "OpenAI"),
                    HostUiState(1L, "Anthropic")
                ),
                selectedHost = 0,
                hostModels = listOf(
                    ModelUiState(0L, "GPT-3.5"),
                    ModelUiState(1L, "GPT4o"),
                ),
                selectedModel = 1,
                instructions = ""
            ),
            AgentUiState(
                agentName = "NurseBot",
                hosts = listOf(
                    HostUiState(0L, "OpenAI"),
                    HostUiState(1L, "Anthropic")
                ),
                selectedHost = 0,
                hostModels = listOf(
                    ModelUiState(0L, "GPT-3.5"),
                    ModelUiState(1L, "GPT4o"),
                ),
                selectedModel = 1,
                instructions = "Provide helpful advice to the user, but you aren't a doctor, so don't give a diagnosis.",
            ),
        )
}
