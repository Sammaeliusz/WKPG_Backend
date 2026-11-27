package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Borrowings
import com.wkgp.model.Instance
import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
interface BorrowingsRepository : CrudRepository<Borrowings, Long> {
    fun findBorrowingsByBorrowerIs(borrower: Player): MutableList<Borrowings>
    fun findBorrowingsByGameIsIn(game: MutableList<Instance>): MutableList<Borrowings>
    fun findBorrowingsByBorrowDateAfterAndReturnDateBeforeAndBorrowerIsOrGameIsIn(
        borrowDate: Date, returnDate: Date, borrower: Player, game: MutableCollection<Instance>
    ): MutableList<Borrowings>
}


