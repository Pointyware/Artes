/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels

/**
 *
 */
sealed interface LoadingUiState {
    data object Idle: LoadingUiState
    data object Loading : LoadingUiState
    data class Error(val message: String) : LoadingUiState
}
