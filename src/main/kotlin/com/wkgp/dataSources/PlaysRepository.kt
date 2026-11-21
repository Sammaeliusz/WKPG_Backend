package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Player
import com.wkgp.model.Plays
import com.wkgp.model.Scores
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaysRepository: CrudRepository<Plays, Long> {
    fun findAllByGame(gra: BoardGame): MutableList<Plays>?
    fun findAllByScoresAndId(
        scores: kotlin.collections.MutableList<com.wkgp.model.Scores>,
        id: Int
    ): kotlin.collections.MutableList<com.wkgp.model.Plays>?
    fun findAllByScores(scores: MutableList<Scores>): MutableList<Plays>
}