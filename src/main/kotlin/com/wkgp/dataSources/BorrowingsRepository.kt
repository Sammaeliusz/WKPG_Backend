package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Borrowings
import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.sql.Date
import java.time.LocalDate

@Repository
<<<<<<< Updated upstream
interface BorrowingsRepository: CrudRepository<Borrowings, Long> {
    fun findBorrowingsByBorrowerIs(borrower: Player): MutableList<Borrowings>
    fun findBorrowingsByGameIsIn(gry: kotlin.collections.MutableCollection<com.wkgp.model.BoardGame>): kotlin.collections.MutableList<com.wkgp.model.Borrowings>
}}
=======
interface BorrowingsRepository : CrudRepository<Borrowing, Long> {
    fun findBorrowingsByBorrowerIs(borrower: Player): MutableList<Borrowing>
    fun findBorrowingsByGameIsIn(gry: MutableCollection<Instance>): MutableList<Borrowing>
    fun findBorrowingsByBorrowDateAfterAndReturnDateBeforeAndBorrowerIsOrGameIsIn(
        borrowDate: LocalDate, returnDate: LocalDate, borrower: Player, game: MutableCollection<Instance>
    ): MutableList<Borrowing>
}
>>>>>>> Stashed changes
