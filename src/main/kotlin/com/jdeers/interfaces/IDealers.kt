package com.jdeers.interfaces
import com.jdeers.entities.EDealer

interface IDealers {
    fun getAllNonFiltered(): List<EDealer>
}
