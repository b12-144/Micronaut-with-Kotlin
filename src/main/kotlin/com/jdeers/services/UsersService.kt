package com.jdeers.services

import com.jdeers.entities.EUser
import com.jdeers.interfaces.IUsers
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession
import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

//seguindo o tutorial aqui: https://piotrminkowski.wordpress.com/2019/02/19/kotlin-microservices-with-micronaut-spring-cloud-and-jpa/

@Singleton
open class UsersService(@param:CurrentSession @field:PersistenceContext val entityManager: EntityManager) :IUsers {

    //region getAll
    @Transactional
    override fun getAll(listCount:Int, pageNumber:Int, orderBy:String): List<EUser> {
        var qlString = "SELECT x FROM EUser as x"
        qlString+=" order by x."+orderBy;
        val query = entityManager.createQuery(qlString, EUser::class.java)
        if(listCount!=null && listCount>0) {
            query.maxResults=listCount
            if(pageNumber!=null)query.firstResult=pageNumber*listCount;
        };
        return query.resultList
    }
    //endregion

    //region getByID
    @Transactional
    override fun getByID(id: Long): EUser? {
        return entityManager.find(EUser::class.java, id)
    }
    //endregion

    //region insert
    @Transactional
    override fun insert(eUser:EUser): Long {
        entityManager.persist(eUser);
        return eUser.id;
    }
    //endregion

    //region update
    @Transactional
    override fun update(eUser:EUser): Boolean {
        if(getByID(eUser.id)==null)return false;
        entityManager.merge(eUser);
        return true
    }
    //endregion

    //region save
    @Transactional
    override fun save(eUser: EUser): Long {
        if(eUser.id<1) entityManager.persist(eUser)
        else entityManager.merge(eUser)
        return eUser.id;
    }
    //endregion

    //region remove
    @Transactional
    override fun remove(id: Long):Boolean {
        val e = getByID(id) ?: return false
        entityManager.remove(e)
        return true
    }
    //endregion
}
