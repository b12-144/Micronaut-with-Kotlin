package com.test

import com.jdeers.codes.Defines
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import javax.inject.Inject

@MicronautTest
open class BaseTest {

    @Inject
    @field:Client(Defines.baseURL)
    protected lateinit var httpClient: RxHttpClient
}
