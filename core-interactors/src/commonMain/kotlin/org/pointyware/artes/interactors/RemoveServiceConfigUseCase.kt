/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.interactors

import org.pointyware.artes.data.hosts.ServiceRepository

class RemoveServiceConfigUseCase(
    private val serviceConfigRepository: ServiceRepository,
) {

    suspend fun invoke(id: Long): Result<Unit> = runCatching {
        serviceConfigRepository.removeService(id)
    }
}
