/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.shared.viewmodels

import org.pointyware.artes.services.openai.network.OpenAiCredentials

/**
 *
 */
data class SettingsUiState(
    val openAiCredentials: OpenAiCredentials? = null,
    val saveEnabled: Boolean = false,
    val saveSuccess: Boolean? = null,
    val error: String? = null,
)
