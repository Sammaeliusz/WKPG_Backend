package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Instance
import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InstancesRepository: CrudRepository<Instance, Long> {
    fun findAllByPlayer(player: Player): MutableList<Instance>;
    fun findAllByPlayerAndGra(player: Player, gra: BoardGame): MutableList<Instance>;
    fun findAllByPlayerAndId(player: Player, id: Long): MutableList<Instance>;
    fun findAllByPlayerAndAvailable(player: Player,available: Boolean): MutableList<Instance>
}