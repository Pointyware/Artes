/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels

/**
 *
 */
data class AgentListUiState(
    val agents: List<AgentInfoUiState> = emptyList(),
    val loading: LoadingUiState = LoadingUiState.Idle,
)
