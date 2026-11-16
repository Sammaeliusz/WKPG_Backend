package com.wkgp.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.sql.Time

@Entity
@Table(name = "GRA")
data class BoardGame(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "Nazwa")
    val name: String,
    @Column(name = "Ciezkosc")
    val weight: Double,
    @Column(name = "Min_graczy")
    val minPlayers: Int,
    @Column(name = "Max_graczy")
    val maxPlayers: Int,
    @Column(name = "Czas")
    val time: Time,
    @Column(name = "Gatunek")
    val genre: Int,
    @Column(name = "Kooperacja")
    val coop: Boolean,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(name = "TAG_GRY", joinColumns = [(JoinColumn(name = "Gra_Id"))], inverseJoinColumns = [(JoinColumn(name = "Tag_Id"))])
    val gameTags: MutableSet<Tags>,
)
