/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.services.openai.network.di

import org.pointyware.artes.services.openai.network.OpenAiCredentials
import org.pointyware.artes.services.openai.network.openAiCredentials

/**
 */
actual fun platformDefaultOpenAiCredentials(): OpenAiCredentials {
    return openAiCredentials().getOrThrow()
}
