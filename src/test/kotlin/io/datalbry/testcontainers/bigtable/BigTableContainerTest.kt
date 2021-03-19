package io.datalbry.testcontainers.bigtable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
internal class BigTableContainerTest {

    companion object {
        @Container private val bigTable = BigTableContainer()
    }

    @Test
    fun test() {
        assertTrue(bigTable.isRunning)
    }

}
