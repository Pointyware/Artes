/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.interactors.agents

import org.pointyware.artes.data.agents.AgentRepository
import org.pointyware.artes.entities.Agent

/**
 *
 */
class GetAgentUseCase(
    private val agentRepository: AgentRepository
) {

    suspend operator fun invoke(id: Long): Result<Agent> = runCatching {
        agentRepository.getAgent(id)
    }
}
