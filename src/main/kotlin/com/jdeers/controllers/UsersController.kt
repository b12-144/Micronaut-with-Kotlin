//region imports
package com.jdeers.controllers
import com.jdeers.codes.Logger
import com.jdeers.entities.EUser
import com.jdeers.interfaces.IUsers
import com.jdeers.services.UsersService
import io.micronaut.context.BeanContext
import io.micronaut.data.annotation.Query
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import java.util.*
import javax.annotation.Nullable
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.validation.Valid
//endregion


@Controller("/users")
@Schema(name = "Users", description = "Users Controller")
open class UsersController {

    @Inject lateinit var usersService:UsersService

    //region getAllUsers
    @Get("/")
    @Operation(summary = "Returns all users", description = "Returns all users")
    @Tag(name = "getAllUsers")
    @ApiResponses(
            ApiResponse(responseCode = "200", description = "Returns all users", content = [(Content(mediaType = "application/json", array = (ArraySchema(schema = Schema(implementation = EUser::class)))))]),
            ApiResponse(responseCode = "500", description = "Server error"))
    open fun getAll(@Nullable @QueryValue(defaultValue = "-1") listCount: Int, @Nullable @QueryValue(defaultValue = "0") pageNumber: Int, @Nullable @QueryValue(defaultValue = "id desc") orderBy: String): HttpResponse<List<EUser>> {
        try {
            val result = usersService.getAll(listCount, 1, "id desc");
            return HttpResponse.ok(result);
        } catch (ex: Exception) {
            Logger.logError(ex)
            return HttpResponse.serverError()
        }
    }
    //endregion

    //region getUserByID
    @Get("/{id}")
    @Operation(summary = "Returns the user by its id", description = "Returns the user by its id")
    @Tag(name = "getUserByID")
    @ApiResponses(
            ApiResponse(responseCode = "200", description = "Returns a user", content = [Content(mediaType = "application/json", schema = Schema(implementation = EUser::class))]),
            ApiResponse(responseCode = "500", description = "Server error"),
            ApiResponse(responseCode = "400", description = "Not found")
    )
    open fun getByID(id: Long): HttpResponse<EUser> {
        try {
            val response = usersService.getByID(id)
            if (response == null) return HttpResponse.notFound()
            else return HttpResponse.ok(response)
        } catch (ex: Exception) {
            Logger.logError(ex)
            return HttpResponse.serverError()
        }
    }
    //endregion

    //region saveUser
    @Post("/save")
    @Operation(summary = "Saves (update or insert) the user")
    @Tag(name = "saveUser")
    @ApiResponses(ApiResponse(responseCode = "200", description = "User saved"),
            ApiResponse(responseCode = "500", description = "Server error"))
    open fun save(@Body @Valid e: EUser): HttpResponse<Long> {
        try {
            val id = usersService.save(e)
            return HttpResponse.ok(id)
        } catch (ex: Exception) {
            Logger.logError(ex)
            return HttpResponse.serverError()
        }
    }
    //endregion

    //region insertUser
    @Post
    @Operation(summary = "Inserts the user")
    @Tag(name = "insertUser")
    @ApiResponses(ApiResponse(responseCode = "201", description = "User inserted"),
            ApiResponse(responseCode = "500", description = "Server error"))
    open fun insert(@Body @Valid eUser: EUser): HttpResponse<Long> {
        try {
            val result=usersService.insert(eUser)
            return HttpResponse.created(result)
        } catch (ex: Exception) {
            Logger.logError(ex)
            return HttpResponse.serverError()
        }
    }
    //endregion

    //region updateUser
    @Put
    @Operation(summary = "Updates the user")
    @Tag(name = "updateUser")
    @ApiResponses(ApiResponse(responseCode = "200", description = "User updated"),
            ApiResponse(responseCode = "500", description = "Server error"),
            ApiResponse(responseCode = "400", description = "Not found"))
    open fun update(@Body @Valid eUser: EUser): HttpResponse<Boolean> {
        try {
            if (usersService.update(eUser)) return HttpResponse.ok(true)
            else return HttpResponse.notFound()
        } catch (ex: Exception) {
            Logger.logError(ex)
            return HttpResponse.serverError()
        }
    }
    //endregion

    //region removeUserByID
    @Delete("/{id}")
    @Operation(summary = "Deletes the user", description = "Deletes the user")
    @Tag(name = "removeUserByID")
    @ApiResponses(ApiResponse(responseCode = "200", description = "User removed"),
            ApiResponse(responseCode = "500", description = "Server error"),
            ApiResponse(responseCode = "400", description = "Not found"))
    open fun remove(@PathVariable id: Long): HttpResponse<Any> {
        try {
            if (usersService.remove(id)) return HttpResponse.ok()
            else return HttpResponse.notFound()
        } catch (ex: Exception) {
            Logger.logError(ex)
            return HttpResponse.serverError()
        }
    }
    //endregion
}
