package com.test
import com.jdeers.Application
import com.jdeers.codes.Defines
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

internal class BootstrapTest: BaseTest() {

    @Test
    fun testItWorks() {
        //Assertions.assertTrue(application.isRunning)
    }
}
