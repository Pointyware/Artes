/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels

/**
 * Represents the UI state of an Agent Editor for creating new agents and modifying existing ones.
 */
data class AgentEditorUiState(
    val agentName: String,
    val hosts: List<HostConfigUiState>,
    val selectedHost: Int?,
    val hostModels: List<ModelUiState>,
    val selectedModel: Int?,
    val instructions: String,
) {
    companion object {
        val Empty = AgentEditorUiState(
            agentName = "",
            hosts = emptyList(

            ),
            selectedHost = null,
            hostModels = emptyList(),
            selectedModel = null,
            instructions = "",
        )
    }
}
