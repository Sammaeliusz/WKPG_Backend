package com.wkgp.dataSources

import com.wkgp.model.Borrowing
import com.wkgp.model.Instance
import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
interface BorrowingsRepository : CrudRepository<Borrowing, Long> {
    fun findBorrowingsByBorrowerIs(borrower: Player): MutableList<Borrowing>
    fun findBorrowingsByGameIsIn(game: MutableList<Instance>): MutableList<Borrowing>
    fun findBorrowingsByBorrowDateAfterAndReturnDateBeforeAndBorrowerIsOrGameIsIn(
        borrowDate: Date, returnDate: Date, borrower: Player, game: MutableCollection<Instance>
    ): MutableList<Borrowing>
}