package io.datalbry.testcontainers.bigtable

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy

/**
 * [BigTableContainer] is a simple testcontainer implementation based on the Google Cloud SDK.
 * The underlying BigTable emulator implementation is running in-memory. Therefore it has some limitations
 *
 * @author timo gruen - 2021-03-19
 */
class BigTableContainer(
    version: String = "316.0.0-emulators",
    private val port: Int = 8080
)
    : GenericContainer<BigTableContainer>("gcr.io/google.com/cloudsdktool/cloud-sdk:$version")
{

    private val command = "gcloud beta emulators bigtable start --host-port 0.0.0.0:$port"

    init {
        this.withCommand("/bin/sh", "-c", command)
        this.withExposedPorts(port)
        this.setWaitStrategy(LogMessageWaitStrategy().withRegEx("(?s).*running.*$"));
    }

    fun getPort(): Int {
        return getMappedPort(port)
    }
}
