package com.wkgp.controllers

import com.wkgp.dataSources.PlayerRepository
import com.wkgp.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {
    @Autowired
    lateinit var repository: PlayerRepository

    @RequestMapping("/findAll")
    fun findAll(): MutableIterable<Player> = repository.findAll();


}