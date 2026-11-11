package com.wkgp.dataSources

import com.wkgp.model.Borrowings
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BorrowingsRepository: CrudRepository<Borrowings, Long> {
}