package com.wkgp.controllers

import com.wkgp.dataSources.BoardGameRepository
import com.wkgp.dataSources.BorrowingsRepository
import com.wkgp.dataSources.InstancesRepository
import com.wkgp.dataSources.PlayerRepository
import com.wkgp.model.Borrowing
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.sql.Date
import java.time.LocalDate

@RestController
@RequestMapping("/borrowings{id}")
class BorrowingsController(
    val playerRepository: PlayerRepository,
    val BorrowingsRepository: BorrowingsRepository,
    val InstancesRepository: InstancesRepository,
    val BoardGameRepository: BoardGameRepository
){
    @RequestMapping(value = ["/from_me"])
    fun getBorrowingsFromMe(@PathVariable("id") id: Int): ResponseEntity<List<Borrowing>> {
        val owner = playerRepository.findById(id)
        val biblio = InstancesRepository.findAllByPlayer(owner!!)
        return ResponseEntity.ok(BorrowingsRepository.findBorrowingsByGameIsIn(biblio))
    }
    @RequestMapping(value = ["/to_me"])
    fun getMyBorrowings(@PathVariable("id") id: Int): ResponseEntity<List<Borrowing>> {
        val player = playerRepository.findById(id)
        return ResponseEntity.ok(BorrowingsRepository.findBorrowingsByBorrowerIs(player!!))
    }
    @RequestMapping(value = ["/current/{date}"])
    fun getCurrentBorrowings(@PathVariable("id") id: Int,@PathVariable("date") date: LocalDate): ResponseEntity<List<Borrowing>> {
        val player = playerRepository.findById(id)
        val biblio = InstancesRepository.findAllByPlayer(player!!)
        return ResponseEntity.ok(BorrowingsRepository.findBorrowingsByBorrowDateAfterAndReturnDateBeforeAndBorrowerIsOrGameIsIn(date, date, player, biblio))
    }

}