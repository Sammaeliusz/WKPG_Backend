package com.wkgp.dataSources

import com.wkgp.model.Player
import com.wkgp.model.Plays
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaysRepository: CrudRepository<Plays, Long> {
}