/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities.signals.primitives

import org.pointyware.artes.entities.signals.Signal

/**
 * There are a massive variety of chemoreceptors. In general they sense chemical concentrations.
 * Specifically, they are responsible for sense of smell and taste as well as the ability to sense
 * blood
 */
interface Chemoreceptor<C>: Signal.Primitive {
    val chemicals: C
}
