/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.entities

/**
 * Describes an AI service. In the short-term, we will rely on established AI web services, so these
 * will be remote web services. In the long-term, we may want to support self-hosted services (e.g.
 * HuggingFace) and local services (e.g. Docker containers).
 */
sealed interface Host

/**
 * This can happen when a host/service is removed but an agent previously using that host is
 * retained.
 */
data object None: Host

interface RemoteHost: Host
data object OpenAi: RemoteHost
data object Google: RemoteHost
data object Anthropic: RemoteHost

/**
 * A user-hosted service running externally.
 */
data class SelfHosted(val url: String): RemoteHost

/**
 * Executed on the same device.
 */
interface LocalHost: Host
data object Docker: LocalHost
