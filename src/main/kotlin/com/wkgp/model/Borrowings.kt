package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.sql.Date

@Entity
@Table(name = "WYPOZYCZENIA")
data class Borrowings(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne
    @JoinColumn(name = "GRA_ID", referencedColumnName = "ID")
    val game: Instance,
    @ManyToOne
    @JoinColumn(name = "Wypozyczajacy_ID", referencedColumnName = "ID")
    val borrower: Player,
    @Column(name = "Data_wypozyczenia")
    val borrowDate: Date,
    @Column(name = "Data_zwrotu")
    val returnDate: Date
)
