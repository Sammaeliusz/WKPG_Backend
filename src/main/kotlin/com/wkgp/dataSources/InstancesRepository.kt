package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Instance
import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InstancesRepository : CrudRepository<Instance, Long> {
    fun findAllByPlayer(player: Player): MutableList<Instance>
    fun findAllByAvailable(available: Boolean): MutableList<Instance>
    fun findAllByGame(game: BoardGame): MutableList<Instance>
    fun findAllByPlayerAndGame(player: Player?, game: BoardGame): MutableList<Instance>
    fun findAllByPlayerAndId(player: Player, id: Long): MutableList<Instance>
    fun findAllByPlayerAndAvailable(player: Player?, available: Boolean): MutableList<Instance>
}
