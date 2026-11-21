package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "WYPOZYCZENIA")
class Borrowings(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @ManyToOne
    @JoinColumn(name = "GRA_ID", referencedColumnName = "ID")
    var game: Instance,
    @ManyToOne
    @JoinColumn(name = "Wypozyczajacy_ID", referencedColumnName = "ID")
    var borrower: Player,
    @Column(name = "Data_wypozyczenia")
    var borrowDate: LocalDate?,
    @Column(name = "Data_zwrotu")
    var returnDate: LocalDate?
) {

}
