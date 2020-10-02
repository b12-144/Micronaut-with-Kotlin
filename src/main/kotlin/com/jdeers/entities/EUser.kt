//region imports
package com.jdeers.entities

import io.swagger.v3.oas.annotations.media.Schema
import java.sql.Date
import javax.persistence.*

//endregion

@Entity
@Table(name = "users")
@Schema(name = "EUser", description = "JDF User")//openapi
data class EUser(
        @Id @GeneratedValue val id: Long = 0,
        @Column val dealerID: Long? = null,

        @Column(name = "name", nullable = false)
        @Schema(description = "User name", maxLength = 200)//openapi
        val name: String? = "", //we have to add ? to make it not required to pass over rest

        @Column
        @Schema(description = "Phone", maxLength = 20)
        val phone: String? = null,

        @Column val address: String? = null

//        @Temporal(TemporalType.DATE)
//        var creationDateUTC:Date?,
//
//        @Temporal(TemporalType.DATE)
//        var modificationDateUTC:Date?

//        @ManyToOne
        //   @JsonIgnore
//        val genre: Genre? = null
)
