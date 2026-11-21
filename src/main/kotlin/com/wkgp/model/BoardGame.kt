package com.wkgp.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.sql.Time

@Entity
@Table(name = "GRA")
class BoardGame(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column(name = "Nazwa")
    var name: String,
    @Column(name = "Ciezkosc")
    var weight: Double,
    @Column(name = "Min_graczy")
    var minPlayers: Int,
    @Column(name = "Max_graczy")
    var maxPlayers: Int,
    @Column(name = "Czas")
    var time: Time,
    @Column(name = "Gatunek")
    var genre: String,
    @Column(name = "Kooperacja")
    var coop: Boolean,
    @ManyToMany(cascade = [(CascadeType.MERGE)])
    @JoinTable(name = "TAG_GRY", joinColumns = [(JoinColumn(name = "Gra_Id"))], inverseJoinColumns = [(JoinColumn(name = "Tag_Id"))])
    var gameTags: MutableSet<Tags>,
) {

}
