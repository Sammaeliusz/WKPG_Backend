package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.dataSources.InstancesRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.model.Instance
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collection{id:[0-9]+}")
class CollectionController(
    val instanceRepo: InstancesRepository,
    val boardGameRepo: BoardGameRepository,
    val playerRepo: PlayerRepository
) {

    @RequestMapping("/all")
    fun findAll(@PathVariable id: Int): MutableList<Instance>? =
        instanceRepo.findAllByPlayer(playerRepo.findById(id)!!)

    @RequestMapping("/game/{gameId[0-9]+]}")
    fun findId(@PathVariable id: Int, @PathVariable gameId: Long) =
        instanceRepo.findAllByPlayerAndId(playerRepo.findById(id)!!, gameId)

    @RequestMapping("/game/{name}")
    fun findName(@PathVariable id: Int, @PathVariable name: String): MutableList<Instance>? {
        val tmpGame = boardGameRepo.findByName(name) ?: return null
        return instanceRepo.findAllByPlayerAndGame(playerRepo.findById(id)!!, tmpGame)
    }

    @RequestMapping("/avaliable")
    fun findAval(@PathVariable id: Int) = instanceRepo.findAllByPlayerAndAvailable(playerRepo.findById(id), true)

    @RequestMapping("/unavaliable")
    fun findUnaval(@PathVariable id: Int) = instanceRepo.findAllByPlayerAndAvailable(playerRepo.findById(id), false)

    @RequestMapping("/Game{game_id:[0-9]+]}/addRate{rate}")
    fun addRate(@PathVariable id:Int, @PathVariable game_id:Long, @PathVariable rate: Double){
        findId(id,game_id).rating = rate
    }

}
