/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities.signals.derivatives

import org.pointyware.artes.entities.signals.Signal

/**
 * A series of related images, usually continuous, that depict visual information across time.
 */
interface Video: Signal.Derivative {
    val width: Int
    val height: Int
    // just for modeling; example of architecture disrupting efficiency
    fun getPixel(time: Float, x: Int, y: Int)
}
