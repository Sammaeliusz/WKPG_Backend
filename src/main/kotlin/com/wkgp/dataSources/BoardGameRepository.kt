package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BoardGameRepository: CrudRepository<BoardGame, Long> {
    fun findById(id: Int): BoardGame?;
    fun findByName(@Param("name") name: String): BoardGame?;
}