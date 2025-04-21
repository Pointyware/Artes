/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.interactors.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.pointyware.artes.interactors.BeginAgentCreationJourney
import org.pointyware.artes.interactors.GetAgentListUseCase
import org.pointyware.artes.interactors.agents.GetAgentUseCase
import org.pointyware.artes.interactors.hosts.GetHostServicesUseCase

/**
 *
 */
fun interactorsModule() = module {
    factoryOf(::GetHostServicesUseCase)
    factoryOf(::GetAgentUseCase)
    factoryOf(::GetAgentListUseCase)
    factoryOf(::BeginAgentCreationJourney)
}
