package com.wkgp.dataSources

import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : CrudRepository<Player, Long>{
    fun findById(id: Int): Player?;
    fun findByName(@Param("name") name: String): Player?;
    fun findByEmailIsLikeIgnoreCase(email: String): MutableList<Player>
}