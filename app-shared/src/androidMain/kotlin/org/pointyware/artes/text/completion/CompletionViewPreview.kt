/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.text.completion

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CompletionViewPreview() {
    CompletionView(
        onPromptChanged = {},
        onSubmit = {}
    )
}
