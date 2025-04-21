/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.services.openai.network

import io.ktor.client.HttpClient


const val OPENAI_BASE_URL = "https://api.openai.com/v1/"

/**
 * Creates a ktor [HttpClient] that connects to OpenAI with default platform configuration.
 */
expect fun openAiHttpClient(): HttpClient
