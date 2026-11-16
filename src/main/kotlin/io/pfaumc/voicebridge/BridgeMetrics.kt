package io.pfaumc.voicebridge

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

object BridgeMetrics {
    val activeSessions = AtomicInteger(0)
    val activeGroups = AtomicInteger(0)
    val svcToPlasmoFrames = AtomicLong(0)
    val plasmoToSvcFrames = AtomicLong(0)
    val svcToPlasmoGroupFrames = AtomicLong(0)
    val plasmoToSvcGroupFrames = AtomicLong(0)
    val droppedFrames = AtomicLong(0)
    val transcodingCount = AtomicLong(0)

    fun reset() {
        activeSessions.set(0)
        activeGroups.set(0)
        svcToPlasmoFrames.set(0)
        plasmoToSvcFrames.set(0)
        svcToPlasmoGroupFrames.set(0)
        plasmoToSvcGroupFrames.set(0)
        droppedFrames.set(0)
        transcodingCount.set(0)
    }

    fun log(logger: Logger) {
        logger.info(
            "Bridge metrics: sessions=${activeSessions.get()}, " +
                "groups=${activeGroups.get()}, " +
                "svc->pv=${svcToPlasmoFrames.get()} (group=${svcToPlasmoGroupFrames.get()}), " +
                "pv->svc=${plasmoToSvcFrames.get()} (group=${plasmoToSvcGroupFrames.get()}), " +
                "dropped=${droppedFrames.get()}, " +
                "transcoded=${transcodingCount.get()}"
        )
    }
}
