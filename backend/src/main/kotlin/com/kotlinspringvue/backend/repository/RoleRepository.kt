package com.kotlinspringvue.backend.repository

import com.kotlinspringvue.backend.jpa.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface RoleRepository : JpaRepository<Role, Long> {

    fun findByName(@Param("name") name: String): Role
}