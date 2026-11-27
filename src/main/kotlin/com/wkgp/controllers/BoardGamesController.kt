package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.model.BoardGame
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Time

@RestController
@RequestMapping("/game")
class BoardGamesController(
    val BoardGameRepository : BoardGameRepository,
    val PlayerRepository : BoardGameRepository
) {
    @RequestMapping("/{name}")
    fun findByName(@PathVariable name: String): BoardGame? = BoardGameRepository.findByName(name)
    @RequestMapping("/coops")
    fun findAllCoop():List<BoardGame> = BoardGameRepository.findAllByCoop(true)
    @RequestMapping("/notcoops")
    fun findAllNotCoop():List<BoardGame> = BoardGameRepository.findAllByCoop(false)
    @RequestMapping("/weight/{min}|{max}")
    fun findAllWeight(@PathVariable("min") min: Double,@PathVariable("max") max: Double): List<BoardGame>? =
        BoardGameRepository.findAllByWeightBetween(min, max)
    @RequestMapping("/time/{min}|{max}")
    fun findAlltime(@PathVariable("min") min: Time, @PathVariable("max") max: Time): List<BoardGame>? =
        BoardGameRepository.findAllByTimeBetween(min, max)
}