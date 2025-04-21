/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.interactors.hosts

import org.pointyware.artes.data.hosts.ServiceRepository
import org.pointyware.artes.entities.HostConfig

/**
 * Retrieves a list of registered/configured service host accounts.
 */
class GetHostServicesUseCase(
    private val serviceRepository: ServiceRepository
) {

    suspend operator fun invoke(): Result<List<HostConfig>> = runCatching {
        serviceRepository.getHosts()
    }
}
