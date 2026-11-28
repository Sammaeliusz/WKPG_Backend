package com.wkgp.dataSources

import com.wkgp.model.Player
import com.wkgp.model.Score
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoresRepository : CrudRepository<Score, Long> {
    fun findAllByPlayer(player: Player): List<Score>
    fun findFirstByPlayer(player: Player): Score
}
