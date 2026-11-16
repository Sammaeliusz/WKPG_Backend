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
    fun findAllByAvailable(available: Boolean): MutableList<Instance>
    fun findAllByGra(gra: com.wkgp.model.BoardGame): kotlin.collections.MutableList<com.wkgp.model.Instance>
}