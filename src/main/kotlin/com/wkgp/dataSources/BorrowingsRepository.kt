package com.wkgp.dataSources

import com.wkgp.model.BoardGame
import com.wkgp.model.Borrowings
import com.wkgp.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BorrowingsRepository: CrudRepository<Borrowings, Long> {
    fun findBorrowingsByBorrowerIs(borrower: Player): MutableList<Borrowings>
    fun findBorrowingsByGraIsIn(gry: kotlin.collections.MutableCollection<com.wkgp.model.BoardGame>): kotlin.collections.MutableList<com.wkgp.model.Borrowings>
}