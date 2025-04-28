/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.interactors

import org.pointyware.artes.data.hosts.ServiceRepository
import org.pointyware.artes.entities.Model

class GetServiceModelsUseCase(
    private val serviceRepository: ServiceRepository
) {

    suspend operator fun invoke(hostIndex: Int): Result<List<Model>> = runCatching {
        val host = serviceRepository.getHosts().getOrNull(hostIndex)
            ?: throw IllegalArgumentException("Invalid host index: $hostIndex")
        serviceRepository.getModels(host.id)
    }
}
