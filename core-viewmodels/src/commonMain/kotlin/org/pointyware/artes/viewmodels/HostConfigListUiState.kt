/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels

/**
 */
data class HostConfigListUiState(
    val hostConfigs: List<HostConfigUiState> = emptyList(),
    val loadingUiState: LoadingUiState = LoadingUiState.Idle
)
