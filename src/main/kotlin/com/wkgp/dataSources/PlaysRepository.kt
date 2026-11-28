package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Play
import com.wkgp.model.Score
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaysRepository : CrudRepository<Play, Long> {
    fun findAllByGame(game: BoardGame): List<Play>
    fun findAllByScoresAndId(
        scores: List<Score>,
        id: Int
    ): List<Play>?

    fun findAllByScores(scores: List<Score>): List<Play>
}
