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
data class Instances(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val ID: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WlascicielId")
    val player: Player,
    @ManyToMany
    @JoinTable(name = "GRA")
    val gra: Collection<BoardGame>,
    @Column(name="Dostepna")
    val available: Boolean,
    @Column(name = "Ocena")
    val rating: Int,

    )
