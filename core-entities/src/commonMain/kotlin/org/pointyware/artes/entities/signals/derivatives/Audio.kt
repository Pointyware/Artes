/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities.signals.derivatives

import org.pointyware.artes.entities.signals.Signal

/**
 * A sequence of signals corresponding to pressure waves.
 */
interface Audio<S:Number>: Signal.Derivative {
    /**
     * The individual pressure signals.
     */
    val waveform: Array<S>

    /**
     * The number of samples (signals) per second.
     */
    val sampleRate: Float
}
