package com.wkgp.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "WYPOZYCZENIA")
class Borrowing(
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
)
