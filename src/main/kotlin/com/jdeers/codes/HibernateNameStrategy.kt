package com.jdeers.codes

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment


class HibernateNameStrategy : PhysicalNamingStrategy {
    override fun toPhysicalCatalogName(identifier: Identifier?, jdbcEnv: JdbcEnvironment): Identifier? {
        return convertToLowercase(identifier)
    }

    override fun toPhysicalColumnName(identifier: Identifier?, jdbcEnv: JdbcEnvironment): Identifier? {
        return convertToLowercase(identifier)
    }

    override fun toPhysicalSchemaName(identifier: Identifier?, jdbcEnv: JdbcEnvironment): Identifier? {
        return convertToLowercase(identifier)
    }

    override fun toPhysicalSequenceName(identifier: Identifier?, jdbcEnv: JdbcEnvironment): Identifier? {
        return convertToLowercase(identifier)
    }

    override fun toPhysicalTableName(identifier: Identifier?, jdbcEnv: JdbcEnvironment): Identifier? {
        return convertToLowercase(identifier)
    }

    private fun convertToLowercase(identifier: Identifier?): Identifier? {
        if (identifier == null) return identifier
        var newName=identifier.text.toLowerCase();
        return Identifier.toIdentifier(newName)
    }
}
