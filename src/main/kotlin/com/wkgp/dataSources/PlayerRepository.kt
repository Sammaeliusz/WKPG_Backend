package com.wkgp.dataSources

import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : CrudRepository<Player, Long>{

}