package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
@Entity
@Table(name = "GRACZ")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ID: Int,
    val Email: String,
    @Column(name = "Nazwa_gracza")
    val name: String,
    @Column(name = "Max_ciezkosc")
    val maxWeight:Double,
    @Column(name = "Preferowany_czas")
    val prefTime:Double,
    val PIN: Int,
)