package com.jdeers.interfaces

import com.jdeers.entities.EUser

interface IUsers {
    fun getAll(listCount:Int = -1, pageNumber:Int = 0, orderBy:String = "id desc"): List<EUser>
    fun getByID(id: Long): EUser?
    fun insert(eUser: EUser): Long
    fun update(eUser:EUser): Boolean
    fun save(eUser: EUser): Long
    fun remove(id: Long):Boolean
}
