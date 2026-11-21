package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.dataSources.InstancesRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.dataSources.PlaysRepository
import com.wkgp.dataSources.ScoresRepository
import com.wkgp.dataSources.TagRepository
import com.wkgp.model.BoardGame
import com.wkgp.model.Instance
import com.wkgp.model.Player
import com.wkgp.model.Tags
import com.wkgp.model.Plays
import com.wkgp.model.Scores
import jakarta.validation.constraints.Null
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Score
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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