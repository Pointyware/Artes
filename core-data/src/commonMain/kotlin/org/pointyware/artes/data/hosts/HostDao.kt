/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.data.hosts

import org.pointyware.artes.entities.HostConfig

interface HostDao {
    fun createHost(title: String, orgId: String, apiKey: String): Long
    fun createGeminiHost(title: String, apiKey: String): Long
    fun getHostById(id: Long): HostConfig
    fun getAllHosts(): List<HostConfig>
    fun updateHost(id: Long, title: String, orgId: String, apiKey: String)
    fun deleteHost(id: Long)
}
