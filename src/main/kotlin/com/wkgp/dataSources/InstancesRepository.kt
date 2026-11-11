package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Instance
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InstancesRepository: CrudRepository<Instance, Long> {
    fun findAllByPlayer(@Param("id") playerId: Int): List<BoardGame>;
}