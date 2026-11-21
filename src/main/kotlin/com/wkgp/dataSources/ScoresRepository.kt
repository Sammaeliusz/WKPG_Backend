package com.wkgp.dataSources

import com.wkgp.model.Player
import com.wkgp.model.Scores
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoresRepository: CrudRepository<Scores, Long> {
    fun findAllByPlayer(player: com.wkgp.model.Player): kotlin.collections.MutableList<com.wkgp.model.Scores>?
}