/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.services.openai

import org.pointyware.artes.entities.Google
import org.pointyware.artes.entities.Host
import org.pointyware.artes.entities.HostConfig
import org.pointyware.artes.entities.OpenAi

/**
 * A user's configuration for OpenAI.
 */
class OpenAiConfig(
    override val id: Long,
    override val title: String,
    val orgId: String,
    val apiKey: String,
): HostConfig {

    override val host: Host
        get() = OpenAi
}

/**
 * A user's account configuration for Gemini.
 *
 * TODO: move to Google module
 */
class GeminiConfig(
    override val id: Long,
    override val title: String,
    val apiKey: String,
): HostConfig {

    override val host: Host
        get() = Google
}
