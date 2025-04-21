/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.viewmodels.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.pointyware.artes.viewmodels.AgentListViewModel
import org.pointyware.artes.viewmodels.DefaultAgentListViewModel
import org.pointyware.artes.viewmodels.DefaultServiceListViewModel
import org.pointyware.artes.viewmodels.ServiceListViewModel

/**
 *
 */
fun viewModelModule() = module {
    factoryOf(::DefaultAgentListViewModel) {
        bind<AgentListViewModel>()
    }
    factoryOf(::DefaultServiceListViewModel) {
        bind<ServiceListViewModel>()
    }
}
