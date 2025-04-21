/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities.signals.derivatives

import org.pointyware.artes.entities.signals.Signal

/**
 * A sequence of symbols used to communicate concepts (whatever the hell those are).
 */
interface Text<C>: Signal.Derivative {
    val content: C
    val length: Int
}
