package com.kotlinspringvue.backend.repository

import com.kotlinspringvue.backend.jpa.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface BookRepository : JpaRepository<Book,Long>{
    fun findByTittle(@Param("tittle") tittle: String):Book
    fun findByIsRead(@Param("isread") isread: Boolean):List<Book>

}