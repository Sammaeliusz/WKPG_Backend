package com.wkgp.controllers

import com.wkgp.dataSources.PlayerRepository
import com.wkgp.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/player")
class PlayerController {
    @Autowired lateinit var playerRepo: PlayerRepository
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("addPlayer")
    fun addPlayer(@RequestBody player: Player) {
        playerRepo.save(player);
    }
    @RequestMapping("All")
    fun findAll(): List<String>{
        playerRepo.findAll()
        return playerRepo.findAll().map { it.name }
    };
}