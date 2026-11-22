package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Tag
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.sql.Time

@Repository
interface BoardGameRepository : CrudRepository<BoardGame, Long> {
    fun findById(id: Int): BoardGame?
    fun findByName(@Param("name") name: String): BoardGame?
    fun findAllByWeightBetween(minWeight: Double, maxWeight: Double): MutableList<BoardGame>
    fun findAllByTimeBetween(minTime: Time, maxTime: Time): MutableList<BoardGame>
    fun findAllByGameTags(gameTags: MutableSet<Tag>): MutableList<BoardGame>
}
