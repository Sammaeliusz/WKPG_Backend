package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "GRA")
data class BoardGame(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ID: Int,
    @Column(name = "Nazwa")
    val name: String,
    @Column(name = "Ciezkosc")
    val Weight: Double,
    @Column(name = "Min_graczy")
    val minPlayers: Int,
    @Column(name = "Max_graczy")
    val maxPlayers: Int,
    @Column(name = "Czas")
    val time: String,
    @Column(name = "Gatunek")
    val genre: Int,
    @Column(name = "Kooperacja")
    val coop: Boolean,
)
