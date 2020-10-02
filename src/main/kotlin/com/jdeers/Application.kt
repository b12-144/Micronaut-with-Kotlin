//region imports
package com.jdeers
import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*
//endregion

//swagger acessível em http://localhost:8080/swagger/bootstrap-0.0.yml
@OpenAPIDefinition(
    info = Info(
            title = "bootstrap",
			version = "0.0",
			description = "My API",
			license = License(name = "Apache 2.0", url = "https://foo.bar"),
			contact = Contact(url = "https://bozolino.com", name = "Bozo", email = "bozo@sbt.com")
    )
)
object Api {
}

object Application {
	@JvmStatic
	fun main(args: Array<String>) {
//		val context = BeanContext.run()
//		val vehicle = context.getBean(UsersService::class.java)
		Micronaut.build()
				.packages("com.jdeers")
				.mainClass(Application.javaClass)
				.start()
	}
}

