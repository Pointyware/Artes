/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities

/**
 * A registered/known instance of a [Host].
 */
interface HostConfig {
    val id: Long
    val title: String
    val host: Host
}
