/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities

/**
 *
 */
data class Agent(
    val id: Long,
    val name: String,
    val model: Model,
    val skills: Set<Skill>
)
