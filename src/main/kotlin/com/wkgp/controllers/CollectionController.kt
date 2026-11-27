package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.dataSources.InstancesRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.dataSources.ScoresRepository
import com.wkgp.model.BoardGame
import com.wkgp.model.Instance
import com.wkgp.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collection{id:[0-9]+}")
class CollectionController {
    @Autowired lateinit var instanceRepo: InstancesRepository
    @Autowired lateinit var playerRepo: PlayerRepository
    @Autowired lateinit var boardGameRepo: BoardGameRepository
    @RequestMapping("/All")
    fun findAll(@PathVariable id: Int): MutableList<Instance>? = instanceRepo.findAllByPlayer(playerRepo.findById(id)!!);
    @RequestMapping("/Game/{game_id:[0-9]+]}")
    fun findId(@PathVariable id: Int, @PathVariable game_id: Long) = instanceRepo.findByPlayerAndId(playerRepo.findById(id)!!, game_id);
    @RequestMapping("/Game/{name}")
    fun findName(@PathVariable id: Int, @PathVariable name: String): MutableList<Instance>?{
        val tmp_game: BoardGame? = boardGameRepo.findByName(name)
        return if (tmp_game != null){
            instanceRepo.findAllByPlayerAndGame(playerRepo.findById(id)!!, tmp_game)
        }else{
            null;
        }
    };
    @RequestMapping("/Avaliable")
    fun findAval(@PathVariable id: Int) = instanceRepo.findAllByPlayerAndAvailable(playerRepo.findById(id)!!, true);
    @RequestMapping("/Unavaliable")
    fun findUnaval(@PathVariable id: Int) = instanceRepo.findAllByPlayerAndAvailable(playerRepo.findById(id)!!, false);

    @RequestMapping("/Game{game_id:[0-9]+]}/addRate{rate}")
    fun addRate(@PathVariable id:Int, @PathVariable game_id:Long, @PathVariable rate: Double){
        findId(id,game_id).rating = rate
    }

}