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
import com.wkgp.model.Plays
import com.wkgp.model.Scores
import jakarta.validation.constraints.Null
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Score
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
    @Autowired
    lateinit var playsRepo: PlaysRepository
    @Autowired
    lateinit var boardGameRepo: BoardGameRepository
    @Autowired
    lateinit var scoresRepo: ScoresRepository
    @RequestMapping("/findAllPlayer")
    fun findAll(): MutableIterable<Player> = playerRepo.findAll();

    @RequestMapping("/findPlayerByName/{name}")
    fun findByName(@PathVariable name: String): Player? = playerRepo.findByName(@PathVariable name);

    @RequestMapping("/findLibByName/{name}")
    fun findLibByName(@PathVariable name: String): MutableList<Instance>?{
        val tmpPlayer: Player? = playerRepo.findByName(@PathVariable name);
        return if (tmpPlayer != null){
            instanceRepo.findAllByPlayer(tmpPlayer);
        } else{
            null;
        }
    }

    @RequestMapping("/findPlaysByGame/{game}")
    fun findPlaysByGame(@PathVariable game: String): MutableList<Plays>?{
        val tmpGame: BoardGame? = boardGameRepo.findByName(game);
        return if (tmpGame != null){
            playsRepo.findAllByGra(tmpGame);
        }else{
            null;
        }
    }

    @RequestMapping("/findPlaysByPlayer/{name}")
    fun findPlaysByPlayer(@PathVariable name: String): MutableList<Plays>?{
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