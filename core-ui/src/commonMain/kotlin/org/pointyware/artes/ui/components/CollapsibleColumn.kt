/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 *
 */
@Composable
fun CollapsibleColumn(
    header: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        header()

        // TODO: animate collapse
        if (isExpanded) {
            content()
        }
    }
}
