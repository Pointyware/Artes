package org.pointyware.artes.data

import kotlinx.coroutines.flow.Flow

/**
 *
 */
interface SettingsRepository {

    val onValueChange: Flow<String>
    suspend fun get(key: String): String?
    suspend fun set(key: String, value: String)
    suspend fun remove(key: String)

    suspend fun persist()
}
