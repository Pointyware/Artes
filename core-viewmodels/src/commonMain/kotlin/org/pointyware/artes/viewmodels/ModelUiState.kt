/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels

import org.pointyware.artes.entities.Model

/**
 *
 */
data class ModelUiState(
    val id: Long,
    val name: String
)

fun Model.toUiState(): ModelUiState {
    return ModelUiState(
        id = id,
        name = name
    )
}
