package com.wkgp.controllers

import com.wkgp.dataSources.PlayerRepository
import com.wkgp.model.Player
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player")
class PlayerController(
    val playerRepo: PlayerRepository
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("addPlayer")
    fun addPlayer(@RequestBody player: Player) {
        playerRepo.save(player)
    }

    @RequestMapping("All")
    fun findAll(): List<String> {
        playerRepo.findAll()
        return playerRepo.findAll().map { it.name }
    };
}
