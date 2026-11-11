package com.wkgp.controllers

import com.wkgp.dataSources.InstancesRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.dataSources.TagRepository
import com.wkgp.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {
    @Autowired
    lateinit var playerRepo: PlayerRepository
    @Autowired
    lateinit var tagRepo: TagRepository
    @Autowired
    lateinit var instanceRepo: InstancesRepository
    @RequestMapping("/findAll")
    fun findAll(): MutableIterable<Player> = playerRepo.findAll();

    @RequestMapping("/findByName/{name}")
    fun findByName(@PathVariable name: String): Player? = playerRepo.findByName(@PathVariable name);



}