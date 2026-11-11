package com.wkgp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "KOLEKCJA")
data class Instance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Wlasciciel_ID", referencedColumnName = "ID")
    val player: Player,
    @ManyToOne
    @JoinColumn(name = "GRA_ID", referencedColumnName = "ID")
    val gra: BoardGame,
    @Column(name="Dostepna")
    val available: Boolean,
    @Column(name = "Ocena")
    val rating: Int,

    )
