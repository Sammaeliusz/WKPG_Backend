package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.dataSources.PlaysRepository
import com.wkgp.dataSources.ScoresRepository
import com.wkgp.model.BoardGame
import com.wkgp.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import com.wkgp.model.Play
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plays")
class PlaysController(
    val playerRepo: PlayerRepository,
    val scoresRepo: ScoresRepository,
    val boardGameRepo: BoardGameRepository,
    val playsRepo: PlaysRepository
) {
    @RequestMapping("/findByGame/{game}")
    fun findPlaysByGame(@PathVariable game: String): List<Play> {
        val tmpGame = boardGameRepo.findByName(game) ?: return emptyList()
        return playsRepo.findAllByGame(tmpGame)
    }

    @RequestMapping("/findByPlayer/{name}")
    fun findPlaysByPlayer(@PathVariable name: String): List<Play> {
        val tmpPlayer = playerRepo.findByName(name) ?: return emptyList()
        val tmpScores = scoresRepo.findAllByPlayer(tmpPlayer)
        return playsRepo.findAllByScores(tmpScores)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/addPlay")
    fun addPlay(@RequestBody plays: Play){
        playsRepo.save(plays)
    }
}
