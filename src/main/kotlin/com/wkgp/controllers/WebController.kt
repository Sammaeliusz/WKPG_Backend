package com.wkgp.controllers

import com.wkgp.dataSources.InstancesRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.dataSources.PlaysRepository
import com.wkgp.dataSources.TagRepository
import com.wkgp.model.Player
import org.springframework.web.bind.annotation.*

@RestController
class WebController(
    val playerRepository: PlayerRepository,
    val tagRepository: TagRepository,
    val instancesRepository: InstancesRepository,
    val playsRepository: PlaysRepository
) {
    @RequestMapping("/findAll")
    fun findAll(): MutableIterable<Player> = playerRepository.findAll();

    @RequestMapping("/findByName/{name}")
    fun findByName(@PathVariable name: String): Player? = playerRepository.findByName(@PathVariable name);

    @PostMapping("/player")
    fun create(@RequestBody player: Player): Player {
        val savedPlayer = playerRepository.save(player)
        return savedPlayer
    }

}
