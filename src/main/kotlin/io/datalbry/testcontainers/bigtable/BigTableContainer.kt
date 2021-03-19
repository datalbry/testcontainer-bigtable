package io.datalbry.testcontainers.bigtable

import org.testcontainers.containers.GenericContainer

/**
 * [BigTableContainer] is a simple testcontainer implementation based on the Google Cloud SDK.
 * The underlying BigTable emulator implementation is running in-memory. Therefore it has some limitations
 *
 * @author timo gruen - 2021-03-19
 */
class BigTableContainer(
    version: String = "latest"
)
    : GenericContainer<BigTableContainer>("gcr.io/google.com/cloudsdktool/cloud-sdk:$version")
{
    init {
        this.withCommand("gcloud beta emulators bigtable start")
    }
}
