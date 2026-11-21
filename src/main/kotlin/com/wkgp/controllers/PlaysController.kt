package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.dataSources.PlaysRepository
import com.wkgp.dataSources.ScoresRepository
import com.wkgp.model.BoardGame
import com.wkgp.model.Player
import com.wkgp.model.Plays
import com.wkgp.model.Scores
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plays")
class PlaysController {
    @Autowired lateinit var playerRepo: PlayerRepository
    @Autowired lateinit var scoresRepo: ScoresRepository
    @Autowired lateinit var boardGameRepo: BoardGameRepository
    @Autowired lateinit var playsRepo: PlaysRepository
    @RequestMapping("/findByGame/{game}")
    fun findPlaysByGame(@PathVariable game: String): MutableList<Plays>?{
        val tmpGame: BoardGame? = boardGameRepo.findByName(game);
        return if (tmpGame != null){
            playsRepo.findAllByGra(tmpGame);
        }else{
            null;
        }
    }

    @RequestMapping("/findByPlayer/{name}")
    fun findPlaysByPlayer(@PathVariable name: String): Iterable<Plays>? {
        val tmpPlayer: Player? = playerRepo.findByName(@PathVariable name);
        var tmpScores: MutableList<Scores>? = null;
        if (tmpPlayer != null) {
            tmpScores = scoresRepo.findAllByPlayer(tmpPlayer);
        }
        return if (tmpScores != null){
            playsRepo.findAllByScores(tmpScores);
        }else{
            null;
        }
    }
}