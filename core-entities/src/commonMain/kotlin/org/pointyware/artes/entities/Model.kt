/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities

/**
 *
 */
interface Model {
    val id: Long
    val name: String
    val hostConfig: HostConfig
}

data class ModelImpl(
    override val id: Long,
    override val name: String,
    override val hostConfig: HostConfig,
) : Model
