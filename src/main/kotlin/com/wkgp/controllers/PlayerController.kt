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
    @RequestMapping("/addPlayer")
    fun addPlayer(@RequestBody player: Player) {
        playerRepo.save(player)
    }
    @RequestMapping("/All")
    fun findAll(): List<String>{
        playerRepo.findAll()
        return playerRepo.findAll().map { it.name }
    };
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(login: String, PIN: String): Int? {
        val player = playerRepo.findByEmailIsLikeIgnoreCaseAndPin(login, PIN.toInt())
        return player?.id
    }
    @RequestMapping("{id}/friends{fid}")
    fun friends(@PathVariable id: Int): MutableSet<Player>? {
        val yo = playerRepo.findById(id)
        return yo?.friends
    }
    @RequestMapping("{id}/AddFriend{fid}")
    fun addFriend(@PathVariable id: Int, @PathVariable fid: Int){
        val player = playerRepo.findById(id)
        val friend = playerRepo.findById(fid)
        if (friend != null) {
            player?.friends?.add(friend)
        }
    }
}
