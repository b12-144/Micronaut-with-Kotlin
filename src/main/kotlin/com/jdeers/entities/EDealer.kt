package com.jdeers.entities
import javax.persistence.*

@Entity
@Table(name = "dealers")
data class EDealer (
        @Id
        @GeneratedValue
        val id: Long=0,
        @Column(name = "name", nullable = false)
        val name: String="",
        @Column(nullable = false)
        val email: String="",
        @Column(nullable = false)
        val password: String="",
        @Column
        val phone: String="",
        @Column
        val address: String="",
        @Column
        val postalCode: String=""
)
