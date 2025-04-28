/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels

import org.pointyware.artes.entities.Agent

/**
 *
 */
fun Agent.toUiState(): AgentInfoUiState {
    return AgentInfoUiState(
        id = this.id,
        name = this.name,
        host = this.model.hostConfig.toUiState(),
        model = this.model.toUiState(),
    )
}
