/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.data

/**
 * Describes the interactions available on all text completion services.
 */
interface TextCompletionService {
    suspend fun complete(prompt: String): String
}
