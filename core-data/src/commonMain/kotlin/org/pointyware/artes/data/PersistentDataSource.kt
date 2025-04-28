/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.data

/**
 *
 */
interface PersistentDataSource {
    suspend fun get(key: String): String?
    suspend fun set(key: String, value: String)
    suspend fun remove(key: String)

    /**
     * Manually persist the data source.
     */
    suspend fun persist()
}
