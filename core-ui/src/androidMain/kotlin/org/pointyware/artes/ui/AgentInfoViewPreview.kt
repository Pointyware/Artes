/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.pointyware.artes.entities.OpenAi
import org.pointyware.artes.viewmodels.HostConfigUiState

/**
 *
 */
@Preview
@Composable
fun AgentInfoViewPreview() {
    AgentInfoView(
        state = AgentInfoViewState(
            name = "Some Agent",
            description = "An agent",
            hostConfig = HostConfigUiState(
                id = 0L,
                title = "OpenAI Dev",
                host = OpenAi
            )
        ),
        onEdit = {},
        onDelete = {}
    )
}
