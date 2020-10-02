//region imports
package com.test
import com.jdeers.entities.EUser
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


//endregion

internal class UsersControllerTest: BaseTest() {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getAll() {
        //Assertions.assertTrue(result.size>=0)
    }

    @Test
    fun getByID() {
        val eUser= httpClient.toBlocking().retrieve(HttpRequest.GET<Any>("/users/1"), EUser::class.java)
        assertNotNull(eUser)
    }

    @Test
    fun insert() {
        val eUser=EUser(name = "Paquita", address = "rua barbosa 100")
        var response=httpClient.toBlocking().exchange<EUser,Long>(HttpRequest.POST("/users", eUser))
        assertTrue(response.status==HttpStatus.CREATED)
        val body=response.body()
        println("ola");
    }

    @Test
    fun update() {
    }

    @Test
    fun save() {
    }

    @Test
    fun remove() {
    }
}
