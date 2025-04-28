/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.data.di

import org.koin.dsl.module
import org.pointyware.artes.data.JvmDriverFactory
import org.pointyware.artes.local.DriverFactory

/**
 * Desktop implementation platform-specific data module.
 */
actual fun platformDataModule() = module {
    single<DriverFactory> {
        JvmDriverFactory()
    }
}
