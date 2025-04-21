/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the GPL-3.0 license.
 */

package org.pointyware.artes.services

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.pointyware.artes.data.hosts.HostDao
import org.pointyware.artes.data.hosts.ServiceRepository
import org.pointyware.artes.entities.HostConfig
import org.pointyware.artes.entities.Model
import org.pointyware.artes.entities.ModelImpl
import org.pointyware.artes.services.openai.GeminiConfig
import org.pointyware.artes.services.openai.OpenAiConfig
import org.pointyware.artes.services.openai.network.OpenAiModelFetcher

class ServiceRepositoryImpl(
    private val hostDao: HostDao,
    private val openAiModelFetcher: OpenAiModelFetcher,
    private val ioDispatcher: CoroutineDispatcher,
    private val ioScope: CoroutineScope,
): ServiceRepository {

    override suspend fun createOpenAiHost(title: String, orgId: String, apiKey: String) {
        withContext(ioDispatcher) {
            hostDao.createHost(title, orgId, apiKey)
        }
    }

    override suspend fun createGeminiHost(title: String, apiKey: String) {
        withContext(ioDispatcher) { hostDao.createGeminiHost(title, apiKey) }
    }

    override suspend fun getHosts(): List<HostConfig> = withContext(ioDispatcher) {
        hostDao.getAllHosts()
    }

    override suspend fun getService(id: Long): HostConfig {
        TODO("Not yet implemented")
    }

    override suspend fun getModel(id: Long): Model {
        TODO("Not yet implemented")
    }

    override suspend fun getModels(hostId: Long): List<Model> = withContext(ioDispatcher) {
        when (val hostConfig = hostDao.getHostById(hostId)) {
            is OpenAiConfig -> {
                openAiModelFetcher.invoke(hostConfig)
                    .map {
                        ModelImpl(
                            id = it.created,
                            name = it.id,
                            hostConfig = hostConfig
                        )
                    }
            }
            else -> {
                throw IllegalArgumentException("Unsupported host type: ${hostConfig::class.simpleName}")
            }
        }
    }

    override suspend fun removeService(id: Long) {
        TODO("Not yet implemented")
    }
}

data class TestServiceRepository(
    val hostConfigs: MutableList<HostConfig> = mutableListOf(),
    val hostModels: MutableMap<Long, List<Model>> = mutableMapOf(),
): ServiceRepository {
    override suspend fun createOpenAiHost(title: String, orgId: String, apiKey: String) {
        hostConfigs.add(
            OpenAiConfig(
                id = hostConfigs.size.toLong(),
                title = title,
                orgId = orgId,
                apiKey = apiKey,
            )
        )
    }

    override suspend fun createGeminiHost(title: String, apiKey: String) {
        hostConfigs.add(
            GeminiConfig(
                id = hostConfigs.size.toLong(),
                title = title,
                apiKey = apiKey,
            )
        )
    }

    override suspend fun getHosts(): List<HostConfig> {
        return hostConfigs
    }

    override suspend fun getService(id: Long): HostConfig {
        return hostConfigs.first { it.id == id }
    }

    override suspend fun getModel(id: Long): Model {
        return hostModels.values.flatten().first { it.id == id }
    }

    override suspend fun getModels(hostId: Long): List<Model> {
        delay(2000)
        return hostModels.get(hostId)
            ?: throw IllegalArgumentException("No models found for host with id $hostId")
    }

    override suspend fun removeService(id: Long) {
        TODO("Not yet implemented")
    }
}
