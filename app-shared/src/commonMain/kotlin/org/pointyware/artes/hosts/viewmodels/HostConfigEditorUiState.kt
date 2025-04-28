/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.hosts.viewmodels

import org.pointyware.artes.viewmodels.LoadingUiState

/**
 * Represents the UI state for a host configuration editor.
 */
data class HostConfigEditorUiState(
    val title: String = "",
    val extraOptions: ExtraOptionsUiState = ExtraOptionsUiState.OpenAi(),
    val loading: LoadingUiState
)

/**
 * UI state for host-specific configuration options.
 */
sealed class ExtraOptionsUiState {
    data class OpenAi(
        val orgId: String = "",
        val apiKey: String = "",
    ) : ExtraOptionsUiState()

    data class Gemini(
        val apiKey: String = "",
    ) : ExtraOptionsUiState()
}
