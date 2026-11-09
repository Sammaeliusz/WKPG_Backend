package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.sql.Date

@Entity
@Table(name = "WYPOZYCZENIA")
data class Borrowings(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ID: Int,
    @ManyToOne
    @JoinTable(name = "KOLEKCJA")
    @Column(name = "Gra_Id")
    val gra: BoardGame,
    @ManyToOne
    @JoinTable(name = "GRACZ")
    @Column(name = "Wypozyczajacy_Id")
    val borrower: Player,
    @Column(name = "Data_wypozyczenia")
    val borrowDate: Date,
    @Column(name = "Data_zwrotu")
    val returnDate: Date
)
