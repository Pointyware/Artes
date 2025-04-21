/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.data

import kotlinx.coroutines.flow.Flow

/**
 * A repository of application settings that are stored as String key/value pairs.
 */
interface SettingsRepository {

    val onValueChange: Flow<String>
    suspend fun get(key: String): String?
    suspend fun set(key: String, value: String)
    suspend fun remove(key: String)

    suspend fun persist()
}
